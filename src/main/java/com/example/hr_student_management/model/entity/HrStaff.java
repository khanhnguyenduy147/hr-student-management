package com.example.hr_student_management.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.Data;

@Enabled
@Data
@Table(name = "HR_STAFF")
public class HrStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "FULLNAME")
    String fullName;

    @Column(name = "ID_BRANCH_COMPANY")
    Long idBranchCompany;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "CONTACT")
    String contact;
}
