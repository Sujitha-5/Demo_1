package com.example.spring_mongo_employee.exception;

import com.example.spring_mongo_employee.response.ResponseDTO;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(IdNotPresentException.class)
    public ResponseDTO idnotPresent(IdNotPresentException exception)
    {
        return  new ResponseDTO(exception.getMessage(),HttpStatus.NO_CONTENT.value(),"No Content");
    }

    @ExceptionHandler(EmailNotPresentException.class)
    public ResponseDTO emailIsNotPresent(EmailNotPresentException exception)
    {
        return new ResponseDTO(exception.getMessage(),HttpStatus.NO_CONTENT.value(),"No Content");

    }
    @ExceptionHandler(EmailExistException.class)
    public ResponseDTO emailexist(EmailExistException exception)
    {
        return new ResponseDTO(exception.getMessage(),HttpStatus.ALREADY_REPORTED.value(),"Person with this email is already exist");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException exception)
    {
        Map<String,String> map=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->map.put(error.getField(),error.getDefaultMessage()));
        return map;
    }

}
