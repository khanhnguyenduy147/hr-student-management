package com.example.hr_student_management.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "REFERRER")
public class Referrer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", length = 10)
    private Long id;

    @Column(name = "FULL_NAME", length = 100)
    private String fullName;

    @Column(name = "MOBILE_NUMBER", length = 15)
    private String mobileNumber;

    @Column(name = "WORKPLACE", length = 200)
    private String workplace;
}
