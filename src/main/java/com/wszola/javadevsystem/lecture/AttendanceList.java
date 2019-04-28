package com.wszola.javadevsystem.lecture;

import javax.persistence.*;

@Entity
@Table(name="attendance_list")
public class AttendanceList {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToOne
    @MapsId
    private Lecture lecture;



}
