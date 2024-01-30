package com.example.spring_mongo_employee.facade;

import com.example.spring_mongo_employee.dto.StudentDTO;
import com.example.spring_mongo_employee.dto.StudentRequestDTO;
import com.example.spring_mongo_employee.model.Student;
import com.example.spring_mongo_employee.response.ResponseDTO;
import com.example.spring_mongo_employee.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@ConditionalOnBean(name = "student")
public class StudentFacade {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO studentDTODTO(Student student)
    {
        StudentDTO studentDTO= this.modelMapper.map(student,StudentDTO.class);
        modelMapper.typeMap(Student.class,StudentDTO.class).addMapping(Student::getEmail,StudentDTO::setEmail);
        return studentDTO;
    }

    public Student student(StudentRequestDTO studentDTO)
    {
        return this.modelMapper.map(studentDTO,Student.class);
    }
    public ResponseDTO saveStudent(StudentRequestDTO student)
    {
        Student student1=student(student);
        Student student2=studentService.saveStudent(student1);
        return new ResponseDTO(student2, HttpStatus.CREATED.value(), "Created");
    }

    public ResponseDTO updateStudent(String id,String email)
    {
        Student student=studentService.updateStudent(id,email);
        return new ResponseDTO(student,HttpStatus.OK.value(), "Updated");
    }

    public ResponseDTO findById(String id)
    {
        Student student=studentService.getStudentById(id);
        return new ResponseDTO(student,HttpStatus.FOUND.value(), "Found");
    }

    public ResponseDTO deleteStudent(String id)
    {
        String message=studentService.deleteStudent(id);
        return new ResponseDTO(message,HttpStatus.OK.value(), "Deleted");
    }

    public ResponseDTO findAll()
    {
        List<Student> students=studentService.findAll();
        return new ResponseDTO(students,HttpStatus.FOUND.value(), "Found");
    }


}
