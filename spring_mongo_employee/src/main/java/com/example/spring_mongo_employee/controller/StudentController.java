package com.example.spring_mongo_employee.controller;


import com.example.spring_mongo_employee.config.BeanConfigure;
import com.example.spring_mongo_employee.dto.StudentDTO;
import com.example.spring_mongo_employee.dto.StudentRequestDTO;
import com.example.spring_mongo_employee.facade.StudentFacade;
import com.example.spring_mongo_employee.model.Student;
import com.example.spring_mongo_employee.model.Task;
import com.example.spring_mongo_employee.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@ConditionalOnBean(name = "studentControlBean")
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentFacade studentFacade;
    @Autowired
    private CustomValidator customValidator;
    @PostMapping("/save")
    public ResponseDTO saveStudent(@RequestBody StudentRequestDTO student, BindingResult bindingResult)
    {
        customValidator.validate(student,bindingResult);
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return new ResponseDTO("Error", HttpStatus.BAD_REQUEST.value(),"vallidation failed");
        }
        else {
            return studentFacade.saveStudent(student);
        }

    }
    @PutMapping("/update")
    public ResponseDTO updateStudent(@RequestParam String id,@RequestParam String email)
    {
        return studentFacade.updateStudent(id,email);
    }
    @GetMapping("/findById")
    public ResponseDTO findStudentById(@RequestParam String id)
    {
        return studentFacade.findById(id);
    }
    @DeleteMapping("/delete")
    public ResponseDTO deleteStudent(@RequestParam String id)
    {
        return studentFacade.deleteStudent(id);
    }
    @GetMapping("/findAll")
    public ResponseDTO findAll()
    {
        return studentFacade.findAll();
    }



}
