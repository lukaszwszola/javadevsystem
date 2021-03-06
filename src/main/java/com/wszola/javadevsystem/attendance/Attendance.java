package com.wszola.javadevsystem.attendance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wszola.javadevsystem.lecture.Lecture;
import com.wszola.javadevsystem.student.Student;

import javax.persistence.*;

@Entity
@Table(name="attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Lecture lecture;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    private boolean present;

    public Attendance() {
    }

    public Attendance(Lecture lecture, Student student, boolean present) {
        this.lecture = lecture;
        this.student = student;
        this.present = present;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
