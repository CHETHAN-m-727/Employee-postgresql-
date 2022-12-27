package com.firstock.employee.controller;

import com.firstock.employee.employeeService.EmployeeService;
import com.firstock.employee.entity.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/save")
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.createEmp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmp() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmp(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable int id) {
        return new ResponseEntity<Employee>(employeeService.getEmpById(id), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable int id) {

        employeeService.deleteEmp(id);
        return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable int id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmp(id, employee), HttpStatus.OK);
    }

}
