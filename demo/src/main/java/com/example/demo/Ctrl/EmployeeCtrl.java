package com.example.demo.Ctrl;


import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/emp")
public class EmployeeCtrl
{
    @Autowired
    EmployeeService employeeService;

     @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee){
         return employeeService.saveEmployee( employee );
     }


     @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
         return  employeeService.getAllEmployees();
     }

     @GetMapping("/get/{id}")
    public Optional<Employee> getOneEmployee( @PathVariable Long id ){
         return employeeService.getEmployeeById( id );
     }

     @GetMapping("/findAll")
    public List<Employee> findAllEmployees(){
         return employeeService.findAllEmployee();
     }

     @GetMapping("/findActive")
    public List<Employee> findActive(){
         return employeeService.findActive();
     }
    @GetMapping("/findName/{name}")
    public List<Employee> findName(@PathVariable String name){
        return employeeService.findByName( name );
    }


    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable Long id){
         employeeService.deleteEmployee( id );
         return true;
    }

//     @DeleteMapping("/delete/{des}")
//    public List<Employee> deleteEmpByDesignation(@PathVariable String des){
//         return employeeService.deleteEmployee(des);
//     }
}
