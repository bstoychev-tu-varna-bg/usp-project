package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.model.Employee;
import com.tuvarna.uspproject.repository.EmployeeRepository;
import com.tuvarna.uspproject.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public final class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
