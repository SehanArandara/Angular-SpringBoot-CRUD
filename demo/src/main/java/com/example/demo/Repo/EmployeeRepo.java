package com.example.demo.Repo;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long>
{
   // public List<Employee> deleteEmployee( String des );
    @Query("SELECT e from Employee e")
    public List<Employee> findAllEmployees();

    @Query("SELECT e from Employee e where e.active=true ")
    public List<Employee> findActive();

    @Query("select e from Employee e where e.name=:name")
    public List<Employee> findByName( @Param ("name" ) String name);
}
