package com.example.spring_mongo_employee.exception;

import lombok.Data;

@Data
public class IdNotPresentException extends RuntimeException{

    private static final String MESSAGE="Id is not present";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
