package com.example.hr_student_management;

import com.example.hr_student_management.model.ClassDescription;
import com.example.hr_student_management.model.TestClass2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HrStudentManagementApplication {

	public static void main(String[] args) throws JsonProcessingException {
//		SpringApplication.run(HrStudentManagementApplication.class, args);
		List<ClassDescription.FieldDescription> fields = ClassDescription.describeClassFields(TestClass2.class);

		// Chuyển đổi danh sách FieldDescription sang JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fields);

		// In ra JSON
		System.out.println(jsonOutput);
	}
}
