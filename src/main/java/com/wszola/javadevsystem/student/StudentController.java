package com.wszola.javadevsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value="api/students",method=RequestMethod.POST)
    public Student addEntity(@RequestBody Student student) {
        return studentService.addEntity(student);
    }

  //  @RequestMapping(method = RequestMethod.PUT, path = "/studens/{userId")
  //  public UserDetails updateUserDetails(@PathVariable("userId)"))

}
