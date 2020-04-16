package com.tuvarna.uspproject.service.api;

import com.tuvarna.uspproject.model.Employee;

import java.util.Collection;
import java.util.UUID;

public interface EmployeeService {
    void save(Employee employee);
    void update(Employee employee);
    Employee findById(UUID id);
    Collection<Employee> findAll();
}
