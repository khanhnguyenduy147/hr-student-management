package com.example.hr_student_management.model.response;

import com.example.hr_student_management.model.entity.ClassDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDescriptionRepository extends JpaRepository<ClassDescription, String> {
}
