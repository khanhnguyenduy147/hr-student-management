package com.example.hr_student_management.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ClassDescription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassDescription implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @Column(name = "key_field", length = 100)
    private String keyField;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "inputType", length = 50)
    private String inputType;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "required", length = 1)
    private boolean required;

    @Column(name = "minLength")
    private Integer minLength;

    @Column(name = "maxLength")
    private Integer maxLength;

    @Column(name = "parentId", length = 100)
    private String parentId;

    @Column(name = "api", length = 255)
    private String api;

    @Column(name = "apiLabel", length = 100)
    private String apiLabel;

    @Column(name = "apiValue", length = 100)
    private String apiValue;

    @Lob
    @Column(name = "data")
    private String data; // CLOB type mapped as String

    @Column(name = "disabled", length = 1)
    private boolean disabled;

    @Column(name = "defaultValue", length = 255)
    private String defaultValue;
}
