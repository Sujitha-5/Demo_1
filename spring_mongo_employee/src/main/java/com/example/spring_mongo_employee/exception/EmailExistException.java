package com.example.spring_mongo_employee.exception;

import lombok.Data;

@Data
public class EmailExistException extends RuntimeException{

    private static final String MESSAGE="Email is already exist";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
