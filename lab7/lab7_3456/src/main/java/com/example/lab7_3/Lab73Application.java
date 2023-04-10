package com.example.lab7_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab73Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab73Application.class, args);
	}


	@Autowired
	private StudentSortingRepository studentSortingRepository;

	@Autowired
	private StudentRepository studentRepository;

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


			// Read the list of students, sorted in descending order by age and ascending order by ielts score
			List<Student> sortedStudents = (List<Student>) studentSortingRepository.findAll(Sort.by(Sort.Direction.DESC, "age").and(Sort.by(Sort.Direction.ASC, "ieltsScore")));
			System.out.println("List of students sorted by age and ielts score: ");
			sortedStudents.forEach(System.out::println);

			// Read students 4-5-6
			Page<Student> page = studentSortingRepository.findAll(PageRequest.of(1, 3));
			List<Student> students456 = page.getContent();
			System.out.println("List of students 4-5-6: ");
			students456.forEach(System.out::println);

			List<Student> studentsByAge = studentRepository.findByAgeGreaterThanEqual(20);
			System.out.println("List of Students age >= 20:");
			for (Student student : studentsByAge) {
				System.out.println(student);
			}
			long countByIeltsScore = studentRepository.countByIeltsScore(7);
			System.out.println("Count By Ielts Score: ");
				System.out.println(countByIeltsScore);
			List<Student> studentsByName = studentRepository.findByNameContainingIgnoreCase("john");
			System.out.println("List of Students contain name john:");
			for (Student student : studentsByName) {
				System.out.println(student);
			}



		};
	}

}

