package com.example.demo.service;


import com.example.demo.Repo.EmployeeRepo;
import com.example.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Employee> getEmployeeById( Long empId){
        return employeeRepo.findById( empId );
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
}
