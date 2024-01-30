package com.example.spring_mongo_employee.repository;

import com.example.spring_mongo_employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employeerepository extends MongoRepository<Employee,String> {
    @Query("{email:?0}")
    Employee getEmployeeByEmail(String email);

    @Query("{'address.pincode': ?0}")
    List<Employee> getEmployeesByAddress(int pinCode);
}
