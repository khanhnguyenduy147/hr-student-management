package com.example.hr_student_management.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class TestClass2 extends AuditInfo<TestClass2> {
    private OffsetDateTime createAt;
    private String id;
    private Long category;
    private String accountTitle;
    private String currency;
    private LocalDate openingDate;
    private String description;
}