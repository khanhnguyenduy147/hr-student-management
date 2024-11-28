package com.example.hr_student_management.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "NOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "REFERRER_ID")
    private Long referrerId;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "IDENTIFY_NUMBER")
    private String identifyNumber;

    @Column(name = "INITIAL_COURSE")
    private String initialCourse;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "HOMETOWN")
    private String hometown;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STUDENT_STAFF_ID")
    private Long studentStaffId;

    @Column(name = "CONTRACT_CODE")
    private String contractCode;

    @Column(name = "STATUS")
    private String status;
}
