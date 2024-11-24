package com.example.hr_student_management;

import com.example.hr_student_management.service.BussinessFunctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class HrStudentManagementApplication implements CommandLineRunner {

	private final BussinessFunctionService bussinessFunctionService;

	public static void main(String[] args) {
		SpringApplication.run(HrStudentManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Gọi logic xử lý sau khi Spring Boot đã khởi chạy
		bussinessFunctionService.processClassDescriptions();
	}
}
