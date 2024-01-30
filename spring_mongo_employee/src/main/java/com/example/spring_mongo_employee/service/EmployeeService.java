package com.example.spring_mongo_employee.service;

import com.example.spring_mongo_employee.dao.EmployeeDao;
import com.example.spring_mongo_employee.exception.EmailExistException;
import com.example.spring_mongo_employee.exception.EmailNotPresentException;
import com.example.spring_mongo_employee.exception.IdNotPresentException;
import com.example.spring_mongo_employee.model.Employee;
import com.example.spring_mongo_employee.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

//@ConditionalOnBean(name = "employee")
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;



    public Employee saveEmployee(Employee employee)
    {
        Employee employee1=employeeDao.getEmployeeByEmail(employee.getEmail());
        if(employee1==null)
        {
            return employeeDao.saveEmployee(employee);
        }
        else {
            throw new EmailExistException();
        }
    }
    public Employee updateEmployee(String id,String email)
    {
        Employee employee= employeeDao.findEmployeeById(id);
        if(employee!=null)
        {
            employee.setEmail(email);
            return employeeDao.saveEmployee(employee);
        }
        else {
            throw new IdNotPresentException();
        }
    }
    public String deleteEmployee(String id)
    {
        Employee employee= employeeDao.findEmployeeById(id);
        if(employee!=null)
        {
            return employeeDao.deleteEmployee(employee);
        }
        else {
            throw new IdNotPresentException();
        }
    }

    public Employee getEmployeeById(String id)
    {
        Employee employee=employeeDao.findEmployeeById(id);
        if(employee!=null)
        {
            return  employee;
        }
        else {
            throw new IdNotPresentException();
        }
    }

    public Employee getEmployeeByEmail(String email)
    {
        Employee employee=employeeDao.getEmployeeByEmail(email);
        if(employee!=null)
        {
            return employee;
        }
        else {
            throw new EmailNotPresentException();
        }
    }

    public List<Employee> getAllEmployee()
    {
        return employeeDao.findAll();
    }

    public List<Employee> getEmployeeByAddress(int pincode)
    {
        return employeeDao.getEmployeeByAddress(pincode);
    }

    public double avgAge(List<Employee> employees)
    {
        double age=employees.stream().mapToDouble(Employee::getAge).sum();
        return  (age/employees.size());
    }
    public double avgSalary(List<Employee> employees)
    {
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        return  (totalSalary/employees.size());
    }


    public Employee saveEmployeeTask(String id, Task task)
    {
        Employee employee=employeeDao.findEmployeeById(id);
        if(employee!=null)
        {
            employee.setTasks(task);
            return employeeDao.saveEmployee(employee);
        }
        else {
            return null;
        }
    }


//    @Autowired
//    private final WebClient leaveServiceWebClient;
//
//    public EmployeeService(WebClient.Builder webClientBuilder) {
//        this.leaveServiceWebClient = webClientBuilder.baseUrl("http://leave-service-url").build();
//    }

//    public String requestLeave(String employeeId, int days) {
//        // Make a POST request to the leave service to request leave for an employee
//        return leaveServiceWebClient.post()
//                .uri("/api/leave/request")
//                .bodyValue(new LeaveRequest(employeeId, days))
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }

    public Employee updateEmployee(String id,Employee employee)
    {
        Employee employee1=employeeDao.findEmployeeById(id);
        if(employee!=null)
        {
            employee1.setEmail(employee.getEmail());
            return employeeDao.saveEmployee(employee1);
        }
        else {
            return null;
        }
    }


}
