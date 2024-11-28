package com.example.hr_student_management;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class HrStudentManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrStudentManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
