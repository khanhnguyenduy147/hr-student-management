package com.example.hr_student_management.model;

import java.time.LocalDate;

public class TestClass1Request extends AuditInfo<TestClass1Request> {
    private String id;
    private Long category;
    private String accountTitle;
    private String currency;
    private LocalDate openingDate;
    private String description;
    ChildClass childClass;
}

class ChildClass1 {
    String name;
    Long amount;
}