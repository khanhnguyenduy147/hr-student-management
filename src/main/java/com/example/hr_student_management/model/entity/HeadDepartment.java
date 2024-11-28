package com.example.hr_student_management.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "HEAD_DEPARTMENT")
public class HeadDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "FULLNAME")
    String fullName;

    @Column(name = "MOBILE_NUMBER")
    String mobileNumber;

    @Column(name = "ID_BRANCH_COMPANY")
    Long idBranchCompany;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "CONTACT")
    String contact;
}
