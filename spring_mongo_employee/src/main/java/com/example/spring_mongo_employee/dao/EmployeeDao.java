package com.example.spring_mongo_employee.dao;



import com.example.spring_mongo_employee.model.Employee;
import com.example.spring_mongo_employee.repository.Employeerepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
//@ConditionalOnBean(name = "employee")
public class EmployeeDao {

    @Autowired
    private Employeerepository employeerepository;


    public Employee saveEmployee(Employee employee) {

        return employeerepository.save(employee);
    }


    public String deleteEmployee(Employee employee) {
        employeerepository.delete(employee);
        return "deleted";
    }

    public Employee findEmployeeById(String id) {
        Optional<Employee> employee = employeerepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }

    }

    public List<Employee> findAll() {
        return employeerepository.findAll();
    }

    public Employee getEmployeeByEmail(String email) {
        return employeerepository.getEmployeeByEmail(email);

    }

    public List<Employee> getEmployeeByAddress(int pincode)
    {
        return employeerepository.getEmployeesByAddress(pincode);
    }





}
