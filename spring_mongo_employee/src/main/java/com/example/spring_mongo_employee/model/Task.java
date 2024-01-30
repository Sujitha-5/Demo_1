package com.example.spring_mongo_employee.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
public class Task {

    @Id
    private String id;
    private String taskName;
}
