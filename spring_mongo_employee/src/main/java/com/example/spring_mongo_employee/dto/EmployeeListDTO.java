package com.example.spring_mongo_employee.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeListDTO {

    private List<EmployeeDTO> employees;
    private double avgSalary;
    private double avgAge;
}
