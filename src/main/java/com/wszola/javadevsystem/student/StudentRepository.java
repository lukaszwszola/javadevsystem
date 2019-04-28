package com.wszola.javadevsystem.student;

import com.wszola.javadevsystem.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {

}
