package com.example.spring_mongo_employee.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String name;
    private String gender;
    @NotNull
    private String email;
    private String address;

}
