package com.example.spring_mongo_employee.facade;

import com.example.spring_mongo_employee.dto.EmployeeDTO;
import com.example.spring_mongo_employee.dto.EmployeeListDTO;
import com.example.spring_mongo_employee.model.Employee;
import com.example.spring_mongo_employee.model.Task;
import com.example.spring_mongo_employee.response.ResponseDTO;
import com.example.spring_mongo_employee.service.EmployeeService;
import com.example.spring_mongo_employee.service.FeignService;
import com.example.spring_mongo_employee.service.WebClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
//@ConditionalOnBean(name = "employee")
public class EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FeignService feignService;

    @Autowired
    private WebClientService webClientService;
    public EmployeeFacade(FeignService feignService){
        this.feignService=feignService;
    }


    public EmployeeDTO employeeDTO(Employee employee)
    {
        EmployeeDTO employeeDTO= this.modelMapper.map(employee,EmployeeDTO.class);
        modelMapper.typeMap(Employee.class,EmployeeDTO.class).addMapping(Employee::getPhoneNumber,EmployeeDTO::setContactNumber);
        return employeeDTO;
    }
    public ResponseDTO saveEmployee(Employee employee)
    {
        Employee employee1=employeeService.saveEmployee(employee);
        return new ResponseDTO(employee1,HttpStatus.CREATED.value(),"Created");
    }
    public ResponseDTO updateEmployee(String id,String email)
    {
        Employee employee=employeeService.updateEmployee(id,email);
        EmployeeDTO employeeDTO1=employeeDTO(employee);
        return new ResponseDTO(employeeDTO1,HttpStatus.OK.value(),"Updated");
    }

    public ResponseDTO deleteEmployee(String id)
    {
        String message= employeeService.deleteEmployee(id);
        return new ResponseDTO(message,HttpStatus.OK.value(),"Deleted");
    }

    public ResponseDTO getAllEmployees()
    {
        List<Employee> employees=employeeService.getAllEmployee();
        List<EmployeeDTO> employeeDTOlist=new ArrayList<>();

        for(Employee employee:employees)
        {

            employeeDTOlist.add(employeeDTO(employee));
        }
        double avgAge=employeeService.avgAge(employees);
        double avgSalary=employeeService.avgSalary(employees);
        EmployeeListDTO employeeListDTO=new EmployeeListDTO(employeeDTOlist,avgSalary,avgAge);

        return new ResponseDTO(employeeListDTO,HttpStatus.OK.value(),"displayed");
    }

    public ResponseDTO getEmployeeByEmail(String email)
    {
        Employee employee=employeeService.getEmployeeByEmail(email);
        EmployeeDTO employeeDTO1=employeeDTO(employee);

        return  new ResponseDTO(employeeDTO1,HttpStatus.FOUND.value(),"Found");
    }

    public ResponseDTO getEmployeeById(String id)
    {
        Employee employee=employeeService.getEmployeeById(id);
        EmployeeDTO employeeDTO1=employeeDTO(employee);
        return new ResponseDTO(employeeDTO1,HttpStatus.FOUND.value(),"Found");
    }

    public ResponseDTO getEmployeeByAddress(int pincode)
    {
        List<Employee> employee=employeeService.getEmployeeByAddress(pincode);
        return  new ResponseDTO(employee,HttpStatus.FOUND.value(), "Found");
    }

    public ResponseDTO saveEmployeeByTask(String id, Task task)
    {
        Employee employee=employeeService.saveEmployeeTask(id,task);
        return new ResponseDTO(employee,HttpStatus.CREATED.value(), "Created");
    }

    public ResponseDTO saveTask(Task task)
    {
        return new ResponseDTO(feignService.saveTask(task),HttpStatus.CREATED.value(), "Created");
    }

    public ResponseDTO saveWebClient(Task task)
    {
        return new ResponseDTO(webClientService.saveTask(task),HttpStatus.CREATED.value(), "Created");
    }

    public ResponseDTO updateEmployeeByObject(String id,Employee employee)
    {
        Employee employee1=employeeService.updateEmployee(id,employee);
        EmployeeDTO employeeDTO1=employeeDTO(employee);
        return new ResponseDTO(employeeDTO1,HttpStatus.OK.value(), "Updated");
    }

}
