package com.example.demo.service;


import com.example.demo.Repo.EmployeeRepo;
import com.example.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService
{
    @Autowired
    EmployeeRepo employeeRepo;
    public Employee saveEmployee( Employee employee){
       return employeeRepo.save( employee );
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById( Long empId){
        Optional<Employee> tempEmoployee = employeeRepo.findById( empId );
        if(tempEmoployee.isPresent()){
            Employee employee = tempEmoployee.get();
            return employee;
        }
        else{
            return null;
        }
    }

//    public List<Employee> deleteEmployee( String des )
//    {
//        return employeeRepo.deleteEmployee( des );
//    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAllEmployees();
    }

    public List<Employee> findActive(){
        return employeeRepo.findActive();
    }

    public List<Employee> findByName(String name){
        return employeeRepo.findByName(name);
    }

    public boolean deleteEmployee(Long id){
        employeeRepo.deleteById( id );
        return true;
    }

    // update
    public Employee updateEmployee(Long id, Employee employeeDetails){
        Optional<Employee> tempEmoployee = employeeRepo.findById( id );
        if(tempEmoployee.isPresent()){
            Employee employee = tempEmoployee.get();
            employee.setAge( employeeDetails.getAge() );
            employee.setActive( employeeDetails.isActive() );
            employee.setName( employeeDetails.getName() );
            employee.setSalary( employeeDetails.getSalary() );
            employee.setDesignation( employeeDetails.getDesignation( ) );
            employee.setPhoneNumber( employeeDetails.getPhoneNumber() );
            employeeRepo.save( employee );
            return  employee;
        }
        else{
            return null;
        }
    }


}
