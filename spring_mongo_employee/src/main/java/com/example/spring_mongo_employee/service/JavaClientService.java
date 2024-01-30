package com.example.spring_mongo_employee.service;


import com.example.spring_mongo_employee.model.Task;
import com.example.spring_mongo_employee.response.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class JavaClientService {

    private HttpClient httpClient;

    private HttpResponse httpResponse;
    private String url="http://localhost:8081/Task/save";
    private ObjectMapper objectMapper;
    public JavaClientService(HttpClient httpClient,ObjectMapper objectMapper)
    {
        this.httpClient=httpClient;
        this.objectMapper=objectMapper;
    }

    

//    public Task saveTaskJavaClient(Task task)
//    {
//        HttpRequest httpRequest=HttpRequest.newBuilder().uri(URI.create(url)).build();
//        httpClient.send(httpRequest,HttpResponse)
//    }




}
