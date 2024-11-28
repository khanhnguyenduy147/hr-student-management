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
@Table(name = "HUMAN_DIVISON")
public class HumanDivison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "ID_BRANCH_COMPANY")
    Long idBranchCompany;

    @Column(name = "ID_MANAGER")
    Long idManager;

    @Column(name = "MAIN_DISTRICT")
    String mainDistrict;
}
