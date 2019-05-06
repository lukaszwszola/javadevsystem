package com.wszola.javadevsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Student> getStudents(Principal principal) {
        System.out.println(principal);
        return studentService.getStudents();
    }

    @PostMapping(value="students")
    //@RolesAllowed({"ADMIN"})
    @PreAuthorize("hasRole('ADMIN')")
    public Student addEntity(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(value="students/{id}")
    //@RolesAllowed({"ADMIN","USER"})
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('USER')")
    public Student getStudent(@PathVariable("id") int id, Principal principal) {
        Student student = studentService.getStudent(id);
        if(principal.getName().equals("admin")) return student;
        if(principal.getName().equals(student.getStudentNo()) || principal.getName().equals(student.getEmail())) {
            return student;
        }
        return null;
    }

    //@PutMapping(value="students/{id}")
    //public Student updateStudent(@RequestBody Student student) {
    //    return studentService.saveStudent(student);
    //}

    //@PutMapping(value="students/{id}")
    //public Student updateStudent(@PathVariable int id) {
    //   Student student = studentService.getStudent(id);
    //    return studentService.saveStudent(student);
    //}



}
