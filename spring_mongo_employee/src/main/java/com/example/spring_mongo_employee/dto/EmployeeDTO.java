package com.example.spring_mongo_employee.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    private String id;
    private String name;
    private String email;
    private long contactNumber;
}
