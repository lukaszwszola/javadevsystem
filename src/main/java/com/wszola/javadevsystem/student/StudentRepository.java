package com.wszola.javadevsystem.student;

import com.wszola.javadevsystem.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {

    //Student findByStudentNo(String studentNo);
    //Student findByEmail(String email);
    Student findByStudentNoOrEmail(String studentNo, String email);
    Student findById(int Id);
}
