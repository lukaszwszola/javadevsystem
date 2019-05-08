package com.wszola.javadevsystem.student;

import com.wszola.javadevsystem.lecture.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(int id, Student student) {
        student.setId(id);
        return saveStudent(student);
    }

    public void deleteStudent(int id) {
        studentRepository.delete(getStudent(id));
    }

    public Student getStudentByStudentNoOrEmail(String studentNoOrEmail){
        return studentRepository.findByStudentNoOrEmail(studentNoOrEmail, studentNoOrEmail);
    }

}
