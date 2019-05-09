package com.wszola.javadevsystem;

import com.wszola.javadevsystem.attendance.Attendance;
import com.wszola.javadevsystem.attendance.AttendanceRepository;
import com.wszola.javadevsystem.lecture.Lecture;
import com.wszola.javadevsystem.lecture.LectureRepository;
import com.wszola.javadevsystem.student.Student;
import com.wszola.javadevsystem.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaDevSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDevSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner initData (LectureRepository lectureRepository, StudentRepository studentRepository, AttendanceRepository attendanceRepository){
		return args -> {

			lectureRepository.save(new Lecture("Wprowadzenie", "Informacje wstepne o zajeciach...", "Marek Andrzejewski"));
			lectureRepository.save(new Lecture("Java - Podstawy", "Przypomnienie podstaw Javy...", "Grzegorz Kluz"));
			lectureRepository.save(new Lecture("Zaawansowana Java", "Wiecej o Javie...", "Danuta Stolarczyk"));
			lectureRepository.save(new Lecture("GIT", "Cos o systemie kontroli wersji...", "Joanna Majewska"));
			lectureRepository.save(new Lecture("Spring Boot", "Podstawowie wiadomosci o Springu...", "Aleksander Kosarz"));

			studentRepository.save(new Student("Lukasz", "Wszola", "l.w@gmail.com", "$2a$10$sEcave0GvrRCldwyZ0mkzebI2tIOYVIsOroOzkO6RnuDf2oILawc2", "61685"));
			studentRepository.save(new Student("Marian", "Tomkiewicz", "m.t@gmail.com", "$2a$10$sEcave0GvrRCldwyZ0mkzebI2tIOYVIsOroOzkO6RnuDf2oILawc2", "61677"));
			studentRepository.save(new Student("Krzysztof", "Borek", "k.b@gmail.com", "$2a$10$sEcave0GvrRCldwyZ0mkzebI2tIOYVIsOroOzkO6RnuDf2oILawc2", "42111"));
			studentRepository.save(new Student("Weronika", "Dzikon", "w.d@gmail.com", "$2a$10$sEcave0GvrRCldwyZ0mkzebI2tIOYVIsOroOzkO6RnuDf2oILawc2", "56777"));
			studentRepository.save(new Student("Malgorzata", "Potocka", "m.p@gmail.com", "$2a$10$sEcave0GvrRCldwyZ0mkzebI2tIOYVIsOroOzkO6RnuDf2oILawc2", "61678"));

			//FOR TEST:
			//attendanceRepository.save(new Attendance(new Lecture("Spring Boot", "Wprowadzenie do Spring Boota", "Joanna Majewska"), new Student("Lukasz", "Wszola", "l.w@gmail.com", "$2a$10$sEcave0GvrRCldwyZ0mkzebI2tIOYVIsOroOzkO6RnuDf2oILawc2", "61685"), true ));
		};
	}
}