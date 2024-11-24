package com.example.hr_student_management.model;

import java.time.LocalDate;

public class TestClass2Request extends AuditInfo<TestClass2Request> {
    private String id;
    private Long category;
    private String accountTitle;
    private String currency;
    private LocalDate openingDate;
    private String description;
    ChildClass childClass;
}

class ChildClass {
    String name;
    Long amount;
}