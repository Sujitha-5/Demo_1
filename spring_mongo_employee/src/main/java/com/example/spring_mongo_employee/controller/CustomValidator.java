package com.example.spring_mongo_employee.controller;

import com.example.spring_mongo_employee.dto.StudentDTO;
import com.example.spring_mongo_employee.dto.StudentRequestDTO;
import com.example.spring_mongo_employee.model.Student;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class CustomValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        StudentRequestDTO s= (StudentRequestDTO) target;
       // errors.popNestedPath();

        if(s.getEmail()==null)
        {
            errors.rejectValue("email","nullvalue");
        }

    }
}
