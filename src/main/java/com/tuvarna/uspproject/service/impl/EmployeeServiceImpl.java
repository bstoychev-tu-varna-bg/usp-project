package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.exception.NotExistingEmployeeException;
import com.tuvarna.uspproject.model.Employee;
import com.tuvarna.uspproject.repository.EmployeeRepository;
import com.tuvarna.uspproject.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public final class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        if(isExistingEmployee(employee)){
            employeeRepository.save(employee);
        }
        else
            throw new NotExistingEmployeeException("Employee doesn't exist!");
    }

    @Override
    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(()->
                new NotExistingEmployeeException("Employee doesn't exist!"));
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }

    private boolean isExistingEmployee(Employee employee){
        return employeeRepository.existsById(employee.getId());
    }
}
