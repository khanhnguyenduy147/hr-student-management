package com.example.hr_student_management.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TRAIN")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10)
    private Long id;

    @Column(name = "STUDENT_STAFF_ID", length = 10)
    private Long studentStaffId;
}
