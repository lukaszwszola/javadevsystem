package com.wszola.javadevsystem;

import com.wszola.javadevsystem.lecture.Lecture;
import com.wszola.javadevsystem.lecture.LectureRepository;
import com.wszola.javadevsystem.student.Student;
import com.wszola.javadevsystem.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JavaDevSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDevSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner initStudents (StudentRepository studentRepository){
		return args -> {
			//List<String> firstNames = Arrays.asList("udara", "sampath");
			//firstNames.forEach(firstName -> studentRepository.save(new Student(firstName)));
			studentRepository.save(new Student("Lukasz", "Wszola", "lukasz.wszola@gmail.com", "test", "61685"));
			studentRepository.save(new Student("Marian", "Tomkiewicz", "m.t@gmail.com", "test", "61677"));
			studentRepository.save(new Student("Krzysztof", "Borek", "k.b@gmail.com", "test", "42111"));
		};
	}

	@Bean
	CommandLineRunner initLectures (LectureRepository lectureRepository){
		return args -> {
			lectureRepository.save(new Lecture("Wprowadzenie", "Informacje wstepne", "Marek Andrzejewski"));
			lectureRepository.save(new Lecture("Java Podstawy", "Przypomnienie podstaw Javy", "Marek Andrzejewski"));
			lectureRepository.save(new Lecture("Spring Boot", "Wprowadzenie do Spring Boota", "Joanna Majewska"));

		};
	}



}
