package com.example.hr_student_management.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "BUSSINESSFUNCTION")
@NoArgsConstructor
public class BussinessFunction {

    @Id
    @Column(name = "id", length = 255)
    private String id;

    @Column(name = "name", length = 255)
    private String name;
}
