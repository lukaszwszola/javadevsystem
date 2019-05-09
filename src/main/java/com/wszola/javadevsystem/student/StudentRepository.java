package com.wszola.javadevsystem.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {
    Student findByStudentNoOrEmail(String studentNo, String email);
    Student findById(int Id);
}
