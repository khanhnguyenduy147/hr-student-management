package com.example.hr_student_management.model;

import com.example.hr_student_management.config.Api;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassDescriptionFunction {

    public static List<FieldDescription> describeClassFields(Class<?> clazz) {
        return describeClassFields(clazz, new HashSet<>());
    }

    private static List<FieldDescription> describeClassFields(Class<?> clazz, Set<Class<?>> processedClasses) {
        List<FieldDescription> fieldDescriptions = new ArrayList<>();

        // Kiểm tra nếu lớp đã được xử lý
        if (processedClasses.contains(clazz)) {
            return fieldDescriptions;
        }

        // Thêm lớp hiện tại vào danh sách đã xử lý
        processedClasses.add(clazz);

        // Duyệt qua các lớp cha
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            for (Field field : currentClass.getDeclaredFields()) {
                field.setAccessible(true);

                // Xử lý thông tin trường
                String inputType = getFieldType(field);
                String parentId = null; // Giá trị mặc định
                List<FieldDescription.DataOption> dataOptions = new ArrayList<>();
                String api = null, apiLabel = null, apiValue = null;

                // Xử lý @Api nếu có
                if (field.isAnnotationPresent(Api.class)) {
                    Api apiAnnotation = field.getAnnotation(Api.class);
                    api = apiAnnotation.api();
                    apiLabel = apiAnnotation.label();
                    apiValue = apiAnnotation.value();
                } else if (field.getType().isEnum()) {
                    // Nếu là Enum, thêm các giá trị của Enum vào danh sách
                    for (Object enumConstant : field.getType().getEnumConstants()) {
                        dataOptions.add(FieldDescription.DataOption.builder()
                                .label(enumConstant.toString())
                                .value(enumConstant.toString())
                                .build());
                    }
                }

                // Xử lý nếu là kiểu generic (List, Map,...)
                if (field.getGenericType() instanceof ParameterizedType parameterizedType) {
                    var elementType = parameterizedType.getActualTypeArguments()[0];
                    if (elementType instanceof Class<?> elementClass && !elementClass.getTypeName().startsWith("java.")) {
//                        parentId = field.getName();
                        parentId = getFieldType(field);
                        fieldDescriptions.addAll(describeClassFields(elementClass, processedClasses));
                    }
                }

                // Xử lý nếu là lớp tự định nghĩa
                if (!field.getType().getTypeName().startsWith("java.")
                        && !field.getType().isEnum()
                        && !processedClasses.contains(field.getType())) {

                    // Đặt parentId cho các trường con
                    String currentFieldName = field.getName();
                    fieldDescriptions.addAll(describeClassFields(field.getType(), processedClasses).stream()
//                            .map(childField -> childField.toBuilder().parentId(currentFieldName).build())
                            .map(childField -> childField.toBuilder().parentId(getFieldType(field)).build())
                            .toList());
                }

                // Thêm mô tả trường vào danh sách
                fieldDescriptions.add(FieldDescription.builder()
                        .id(field.getName())
                        .key(field.getName() + "_1")
                        .name(formatFieldName(field.getName()))
                        .inputType(inputType)
                        .type(field.getGenericType() instanceof ParameterizedType ? "multi" : "single")
                        .required(field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(NotBlank.class))
                        .minLength(field.isAnnotationPresent(Size.class) ? field.getAnnotation(Size.class).min() : null)
                        .maxLength(field.isAnnotationPresent(Size.class) ? field.getAnnotation(Size.class).max() : null)
                        .parentId(parentId)
                        .api(api)
                        .apiLabel(apiLabel)
                        .apiValue(apiValue)
                        .data(dataOptions)
                        .disabled(false)
                        .defaultValue("")
                        .pattern(field.isAnnotationPresent(Pattern.class) ? field.getAnnotation(Pattern.class).regexp() : null)
                        .build());
            }
            currentClass = currentClass.getSuperclass(); // Tiếp tục với lớp cha
        }

        return fieldDescriptions;
    }

    private static String getFieldType(Field field) {
        if (field.isAnnotationPresent(Size.class) && field.getAnnotation(Size.class).max() > 255) {
            return "textarea";
        }
        if (field.isAnnotationPresent(Pattern.class)) {
            return "subtext";
        }

        // Kiểm tra nếu là danh sách với kiểu phần tử cụ thể
        if (field.getGenericType() instanceof ParameterizedType parameterizedType) {
            var elementType = parameterizedType.getActualTypeArguments()[0];
            if (elementType instanceof Class<?> elementClass) {
                // Xử lý kiểu phần tử
                return switch (elementClass.getSimpleName()) {
                    case "Long", "Integer" -> "number";
                    case "String" -> "text";
                    case "Double", "BigDecimal" -> "decimal";
                    default -> "Object"; // Mặc định nếu không khớp
                    // default -> field.getType().getSimpleName();
                };
            }
        }

        // Xử lý các kiểu cơ bản khác
        return switch (field.getType().getSimpleName()) {
            case "String" -> "text";
            case "Integer", "Long" -> "number";
            case "Double", "BigDecimal" -> "decimal";
            case "boolean", "Boolean" -> "toggle";
            case "Date", "LocalDate", "LocalDateTime", "OffsetDateTime" -> "date";
            case "List" -> "multi";
            default -> "Object";

            // default -> field.getType().getSimpleName();
        };
    }

    private static String formatFieldName(String fieldName) {
        return fieldName.replaceAll("([a-z])([A-Z])", "$1 $2");
    }

    @Builder(toBuilder = true)
    @Getter
    @JsonDeserialize
    public static class FieldDescription {
        private String id;
        private String key;
        private String name;
        private String inputType;
        private String type;
        private boolean required;
        private Integer minLength;
        private Integer maxLength;
        private String parentId;
        private String api;
        private String apiLabel;
        private String apiValue;
        private List<DataOption> data;
        private boolean disabled;
        private String defaultValue;
        private String pattern;

        @Builder
        @Getter
        public static class DataOption {
            private String label;
            private String value;
        }
    }
}

