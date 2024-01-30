package com.example.spring_mongo_employee.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class StudentRequestDTO {
    @Id
    private String id;
    private String name;
    private String gender;
    @NotNull
    private String email;
    private String address;
}
