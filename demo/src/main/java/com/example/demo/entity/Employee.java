package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long empId;
    private String name ;
    private int  age;
    private String phoneNumber ;
    private String designation;
    private Double salary;
    private boolean active;



//    // owning side
//    @OneToOne( cascade= CascadeType.ALL )
//    @JoinColumn(name= "fk")
//    private Address address;



}
