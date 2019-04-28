package com.wszola.javadevsystem.lecture;

import javax.persistence.*;

@Entity
@Table(name="lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="about_instructor")
    private String aboutInstructor;

    @OneToOne(mappedBy = "lecture", cascade = CascadeType.ALL)
    private AttendanceList attendanceList = new AttendanceList();

    public Lecture(){
    }

    public Lecture(String title) {
        this.title = title;
    }
}
