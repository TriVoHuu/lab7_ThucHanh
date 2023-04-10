package com.example.lab7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab72Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab72Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunnerAccount() {
		return args -> {
			System.out.println("52000288-VoHuuTri");

			studentRepository.save(new Student("John", 20, "john@example.com", 6.5));
			studentRepository.save(new Student("Mary", 22, "mary@example.com", 7.5));
			studentRepository.save(new Student("Peter", 19, "peter@example.com", 6.0));

			// Reading the student list
			List<Student> students = (List<Student>) studentRepository.findAll();
			System.out.println("List of Students:");
			for (Student student : students) {
				System.out.println(student);
			}

			// Updating a student's information
			Optional<Student> optionalStudent = studentRepository.findById(1L);
			if (optionalStudent.isPresent()) {
				Student student = optionalStudent.get();
				student.setEmail("john.doe@example.com");
				studentRepository.save(student);
				System.out.println("Updated Student: " + student);
			}

			// Deleting a student from the database
			studentRepository.deleteById(3L);
			System.out.println("Student with ID 3 has been deleted.");

			// Reading the student list after deleting a student
			students = (List<Student>) studentRepository.findAll();
			System.out.println("List of Students:");
			for (Student student : students) {
				System.out.println(student);
			}

		};
	}

	@Autowired
	private StudentRepository studentRepository;
}
