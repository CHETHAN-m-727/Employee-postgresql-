package com.firstock.employee.employeeService;

import com.firstock.employee.entity.Employee;
import com.firstock.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmp(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteEmp(int id) {
        Employee emp = employeeRepository.findById(id).get();
        if (emp != null) {
            employeeRepository.delete(emp);
        }

    }

    @Override
    public Employee updateEmp(int id, Employee employee) {

        Employee oldEmp = employeeRepository.findById(id).get();

        if (oldEmp != null) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }
}
