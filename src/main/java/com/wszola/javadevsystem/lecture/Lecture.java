package com.wszola.javadevsystem.lecture;

import com.wszola.javadevsystem.attendance.Attendance;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank
    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="about_instructor")
    private String aboutInstructor;

    @OneToMany(mappedBy = "lecture")
    private List<Attendance> attendanceList = new ArrayList<>();

    public Lecture(){
    }

    public Lecture(String title, String description, String aboutInstructor) {
        this.title = title;
        this.description = description;
        this.aboutInstructor = aboutInstructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAboutInstructor() {
        return aboutInstructor;
    }

    public void setAboutInstructor(String aboutInstructor) {
        this.aboutInstructor = aboutInstructor;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }
}
