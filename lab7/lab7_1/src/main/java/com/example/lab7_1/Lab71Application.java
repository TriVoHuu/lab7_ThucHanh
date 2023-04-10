package com.example.lab7_1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab71Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab71Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunnerAccount() {
		return args -> {
			System.out.println("52000288-VoHuuTri");
		};
	}
}
