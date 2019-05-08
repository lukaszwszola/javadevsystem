package com.wszola.javadevsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(value="/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(value="/{id}")
    @PostAuthorize("hasAuthority('ADMIN') or principal.username.equals(returnObject.studentNo) or principal.username.equals(returnObject.email)")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @PutMapping(value="/{id}")
    @PostAuthorize("hasAuthority('ADMIN') or principal.username.equals(returnObject.studentNo) or principal.username.equals(returnObject.email)")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
}
