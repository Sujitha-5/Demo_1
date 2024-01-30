package com.example.spring_mongo_employee.service;

import com.example.spring_mongo_employee.model.Task;
import com.example.spring_mongo_employee.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientService {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public ResponseDTO getAll() {
        // Use WebClient to make a GET request
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/Task/findAll")
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();
    }

    public ResponseDTO saveTask(Task task) {
        // Use WebClient to make a POST request
        return webClientBuilder.build()
                .post()
                .uri("http://localhost:8081/Task/save")
                .bodyValue(task)
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();
    }
}
