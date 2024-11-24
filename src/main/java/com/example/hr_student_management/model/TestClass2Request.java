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
    ChildClass22 name;
    Long amount;
}

class ChildClass22 {
    String name2;
    Long amount2;
}