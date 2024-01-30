package com.example.spring_mongo_employee.controller;

import com.example.spring_mongo_employee.facade.EmployeeFacade;
import com.example.spring_mongo_employee.model.Employee;
import com.example.spring_mongo_employee.model.Task;
import com.example.spring_mongo_employee.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.*;

import javax.swing.table.TableStringConverter;
import javax.validation.Valid;


@RestController
@ConditionalOnBean(name = "employeeControlBean")
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeFacade employeeFacade;

//    @Autowired
//    private LeaveService leaveService;

    @PostMapping("/save")
    public ResponseDTO saveEmployee(@Valid @RequestBody Employee employee)
    {
        return employeeFacade.saveEmployee(employee);
    }
    @PutMapping("/update")
    public ResponseDTO updateEmployee(@RequestParam String id,@RequestParam String email)
    {
        return employeeFacade.updateEmployee(id,email);
    }
    @DeleteMapping("/delete")
    public ResponseDTO deleteEmployee(@RequestParam String id)
    {
        return employeeFacade.deleteEmployee(id);
    }
    @GetMapping("/getAll")
    public ResponseDTO getAllEmployee()
    {
        return employeeFacade.getAllEmployees();
    }
    @GetMapping("/getByEmail")
    public ResponseDTO getEmployeeByEmail(@RequestParam String email)
    {
        return employeeFacade.getEmployeeByEmail(email);
    }
    @GetMapping("/getById/{id}")
    public ResponseDTO getEmployeeById(@PathVariable String id)
    {

        return employeeFacade.getEmployeeById(id);
    }

    @GetMapping("/getByPincode")
    public ResponseDTO getEmployeeByAddress(@RequestParam int pincode)
    {
        return employeeFacade.getEmployeeByAddress(pincode);
    }
//    @GetMapping("/getLeave")
//    public String getEmployeeId()
//    {
//        String leaveInfo = leaveService.getLeave();
//        return "Employee Info: " + leaveInfo;
//    }

    @PostMapping("/saveEmployee")
    public ResponseDTO saveEmployeeByTask(@RequestParam String id, @RequestBody Task task)
    {
        return employeeFacade.saveEmployeeByTask(id,task);
    }
    @PostMapping("/saveTask")
    public ResponseDTO saveTask(@RequestBody Task task)
    {
        return employeeFacade.saveTask(task);
    }
    @PostMapping("/saveWebClient")
    public ResponseDTO saveWebClient(@RequestBody Task task)
    {
        return employeeFacade.saveWebClient(task);
    }
    @PutMapping("/updateEmployee")
    public ResponseDTO updateEmployeeObject(@RequestParam String id,@RequestBody Employee employee)
    {
        return employeeFacade.updateEmployeeByObject(id, employee);
    }
}
