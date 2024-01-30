package com.example.spring_mongo_employee;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.spring_mongo_employee.")
@EnableFeignClients
public class SpringMongoEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoEmployeeApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper()
	{

		return new ModelMapper();
	}
}
