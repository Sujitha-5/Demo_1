package com.example.spring_mongo_employee.service;

import com.example.spring_mongo_employee.dao.StudentDao;
import com.example.spring_mongo_employee.exception.EmailExistException;
import com.example.spring_mongo_employee.exception.IdNotPresentException;
import com.example.spring_mongo_employee.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@ConditionalOnBean(name = "student")
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Student saveStudent(Student student)
    {
        try {
            return studentDao.saveStudent(student);
        }
        catch (Exception e)
        {
            throw new EmailExistException();
        }
    }

    public Student updateStudent(String id,String email)
    {
        Student student=studentDao.findStudentById(id);
        if(student!=null)
        {
            student.setEmail(email);
            return studentDao.saveStudent(student);
        }
        else {
            throw new IdNotPresentException();
        }
    }

    public Student getStudentById(String id)
    {
        Student student=studentDao.findStudentById(id);
        if(student!=null)
        {
            return student;
        }
        else {
            throw new IdNotPresentException();
        }
    }

    public List<Student> findAll()
    {
        return studentDao.findAll();
    }

    public String deleteStudent(String id)
    {
        Student student=studentDao.findStudentById(id);
        if(student!=null)
        {

            return studentDao.deleteStudent(id);
        }
        else {
            throw new IdNotPresentException();
        }
    }
}
