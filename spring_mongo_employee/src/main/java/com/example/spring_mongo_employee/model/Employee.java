package com.example.spring_mongo_employee.model;



import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Employee")
public class Employee {

    @Id
    private String id;
    private String name;
    @NotNull(message = "email field should not be empty")
    @NotBlank(message = "email should not be blank")
    private String email;
    private int age;
    private double salary;
    private long phoneNumber;
    private Address address;
    private Task tasks;

}
