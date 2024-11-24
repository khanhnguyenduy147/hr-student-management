package com.example.hr_student_management.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10)
    private Long id;

    @Column(name = "FULL_NAME", length = 100, nullable = false)
    private String fullName;

    @Column(name = "NOBILE_NUMBER", length = 15)
    private String mobileNumber;

    @Column(name = "REFERRER_ID", length = 10)
    private Long referrerId;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "IDENTIFY_NUMBER", length = 20)
    private String identifyNumber;

    @Column(name = "INITIAL_COURSE", length = 50)
    private String initialCourse;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "HOMETOWN", length = 100)
    private String hometown;

    @Column(name = "CONTACT", length = 15)
    private String contact;

    @Column(name = "EMAIL", length = 100, unique = true)
    private String email;

    @Column(name = "STUDENT_STAFF_ID")
    private Long studentStaffId;

    @Column(name = "CONTRACT_CODE", length = 50)
    private String contractCode;

    @Column(name = "STATUS", length = 20)
    private String status;
}
