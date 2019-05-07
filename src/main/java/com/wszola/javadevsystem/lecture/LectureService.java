package com.wszola.javadevsystem.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public Lecture getLecture(int id) {
        return lectureRepository.findById(id);
    }

    public Lecture updateLecture(int id, Lecture lecture) {
        lecture.setId(id);
        return saveLecture(lecture);
    }

    public void deleteLecture(int id) {
        lectureRepository.delete(getLecture(id));
    }
}
