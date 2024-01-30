package com.example.spring_mongo_employee.service;

import com.example.spring_mongo_employee.model.Task;
import com.example.spring_mongo_employee.response.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Service
@FeignClient(name = "employee",url = "http://localhost:8081/Task")
public interface FeignService {
    @GetMapping("/findAll")
    public ResponseDTO getAll();

    @PostMapping("/save")
    public ResponseDTO saveTask(Task task);
}
