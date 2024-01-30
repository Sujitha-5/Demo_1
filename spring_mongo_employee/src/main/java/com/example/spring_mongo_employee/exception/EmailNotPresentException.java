package com.example.spring_mongo_employee.exception;

import lombok.Data;

@Data
public class EmailNotPresentException extends RuntimeException {
    private static final String MESSAGE = "Email is not present";

    public String getMesssage() {
        return MESSAGE;
    }
}


