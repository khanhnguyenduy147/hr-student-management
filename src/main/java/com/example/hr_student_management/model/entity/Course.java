package com.example.hr_student_management.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "COURSE")
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DAY_START")
    private Date dayStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DAY_END")
    private Date dayEnd;
}
