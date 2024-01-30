package com.example.spring_mongo_employee.repository;

import com.example.spring_mongo_employee.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {



}
