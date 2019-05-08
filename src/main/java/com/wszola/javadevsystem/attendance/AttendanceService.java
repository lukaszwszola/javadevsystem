package com.wszola.javadevsystem.attendance;

import com.wszola.javadevsystem.lecture.Lecture;
import com.wszola.javadevsystem.lecture.LectureRepository;
import com.wszola.javadevsystem.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final LectureRepository lectureRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository, LectureRepository lectureRepository) {
        this.attendanceRepository = attendanceRepository;
        this.lectureRepository = lectureRepository;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceRepository.findAll();
    }

    public Attendance addAttendance(Lecture lecture, Student student, boolean present) {
        return attendanceRepository.save(new Attendance(lecture, student, present));
    }

    public List<Attendance> getAttendanceListByLectureId(int id) {
        List<Attendance> attendancesListByLectureId = attendanceRepository.findAll();
        List filtred = attendancesListByLectureId
                .stream()
                .filter(l->l.getLecture().getId()==id)
                .collect(Collectors.toList());
        return filtred;
    }

}
