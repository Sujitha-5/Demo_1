package com.example.spring_mongo_employee.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigure {
    @Bean("employeeControlBean")
    @ConditionalOnProperty(name = "sample.api",havingValue = "employee")
    public Object employeeConfig()
    {
        return new Object();
    }

    @Bean("studentControlBean")
    @ConditionalOnProperty(name = "sample.api",havingValue = "student")
    public Object studentConfig()
    {
        return new Object();
    }


}
