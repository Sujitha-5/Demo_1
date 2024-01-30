package com.example.spring_mongo_employee.dao;

import com.example.spring_mongo_employee.model.Student;
import com.example.spring_mongo_employee.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@ConditionalOnBean(name = "student")
public class StudentDao {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student findStudentById(String id)
    {
        Optional<Student> student =studentRepository.findById(id);
        if(student.isPresent())
        {
            return student.get();
        }
        else {
            return null;
        }
    }
    public String deleteStudent(String id)
    {
        studentRepository.deleteById(id);
        return "deleted";
    }

    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }


}
