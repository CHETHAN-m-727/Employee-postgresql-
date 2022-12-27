package com.firstock.employee.entity;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lsatName;
    private String email;
    private Double salary;

}
