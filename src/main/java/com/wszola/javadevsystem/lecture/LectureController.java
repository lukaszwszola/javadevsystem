package com.wszola.javadevsystem.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
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

}