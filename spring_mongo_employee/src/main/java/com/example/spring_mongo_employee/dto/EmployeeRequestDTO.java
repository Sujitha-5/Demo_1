package com.example.spring_mongo_employee.dto;

import com.example.spring_mongo_employee.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {

    private String id;
    private String name;
    private String email;
    private int age;
    private double salary;
    private long phoneNumber;
    private Address address;
}
