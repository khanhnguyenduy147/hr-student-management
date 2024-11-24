package com.example.hr_student_management.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "COMPANY")
public class CompanyArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10)
    private Long id;

    @Column(name = "DISTRICT_NAME", length = 200)
    private String districtName;
}
