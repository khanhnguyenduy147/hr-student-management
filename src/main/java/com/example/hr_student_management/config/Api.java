package com.example.hr_student_management.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // Annotation áp dụng cho các field
@Retention(RetentionPolicy.RUNTIME) // Annotation được giữ lại ở runtime
public @interface Api {

    String api() default "";

    String label() default "";

    String value() default "";
}

