package com.example.hr_student_management.service;

import com.example.hr_student_management.model.ClassDescriptionFunction;
import com.example.hr_student_management.model.entity.BussinessFunction;
import com.example.hr_student_management.model.entity.ClassDescription;
import com.example.hr_student_management.model.response.ClassDescriptionRepository;
import com.example.hr_student_management.repository.BussinessFuncitonRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BussinessFunctionService {
    private final BussinessFuncitonRepository bussinessFuncitonRepository;
    private final ClassDescriptionRepository classDescriptionRepository;

    public void processClassDescriptions() {
        // Lấy tất cả các BusinessFunction
        List<BussinessFunction> businessFunctions = bussinessFuncitonRepository.findAll();

        for (BussinessFunction businessFunction : businessFunctions) {
            String className = "com.example.hr_student_management.model." + businessFunction.getName() + "Request"; // Thêm hậu tố "Request"

            try {
                // Mô tả các trường của class đó
                Class<?> clazz = Class.forName(className);
                List<ClassDescriptionFunction.FieldDescription> fields = ClassDescriptionFunction.describeClassFields(clazz);
                for (ClassDescriptionFunction.FieldDescription field : fields) {
                    ClassDescription classDescription = new ClassDescription();
                    classDescription.setId(field.getId());
                    classDescription.setKeyField(field.getKey());
                    classDescription.setName(field.getName());
                    classDescription.setInputType(field.getInputType());
                    classDescription.setType(field.getType());
                    classDescription.setRequired(field.isRequired());
                    classDescription.setMinLength(field.getMinLength());
                    classDescription.setMaxLength(field.getMaxLength());
                    classDescription.setApi(field.getApi());
                    classDescription.setApiLabel(field.getApiLabel());
                    classDescription.setApiValue(field.getApiValue());
                    classDescription.setData(field.getData().toString());
                    classDescriptionRepository.save(classDescription);
                }
            } catch (ClassNotFoundException e) {
                // Xử lý khi không tìm thấy class
                System.err.println("Class not found: " + className);
            }
        }
    }
}
