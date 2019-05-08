package com.wszola.javadevsystem.lecture;

import com.wszola.javadevsystem.attendance.Attendance;
import com.wszola.javadevsystem.attendance.AttendanceService;
import com.wszola.javadevsystem.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    private final LectureService lectureService;
    private final AttendanceService attendanceService;
    private final StudentService studentService;

    @Autowired
    public LectureController(LectureService lectureService, AttendanceService attendanceService, StudentService studentService) {
        this.lectureService = lectureService;
        this.attendanceService = attendanceService;
        this.studentService = studentService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<Lecture> getStudents() {
        return lectureService.getLectures();
    }

    @PostMapping(value="/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Lecture addLecture(@RequestBody Lecture lecture) {
        return lectureService.saveLecture(lecture);
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Lecture getLecture(@PathVariable("id") int id) {
        return lectureService.getLecture(id);
    }

    @PutMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Lecture updateLecture(@PathVariable("id") int id, @RequestBody Lecture lecture) {
        return lectureService.updateLecture(id, lecture);
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteLecture(@PathVariable("id") int id) {
        lectureService.deleteLecture(id);
    }

    @GetMapping(value="/{id}/attendance")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Attendance> getAttendanceList(@PathVariable("id") int id) {
        return attendanceService.getAttendanceListByLectureId(id);
    }

    @PostMapping(value="/{id}/attendance")
    @PreAuthorize("hasAuthority('USER')")
    public Attendance addAttendanceByStudent(@PathVariable int id, Principal principal) {
        String currentUserName = principal.getName();
        return attendanceService.addAttendance(getLecture(id),studentService.getStudentByStudentNoOrEmail(currentUserName),true);
    }
}