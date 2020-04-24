package com.tuvarna.uspproject.controller;

import com.tuvarna.uspproject.model.Employee;
import com.tuvarna.uspproject.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@Controller
@RequestMapping("/employees")
public final class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    protected ModelAndView findEmployees(ModelAndView modelAndView) {
        Collection<Employee> employees = employeeService.findAll();
        modelAndView.addObject("employees", employees).setViewName("view-employees");
        return modelAndView;
    }

    @GetMapping("/add")
    protected ModelAndView addEmployee(ModelAndView modelAndView) {
        modelAndView.addObject("employee", new Employee()).setViewName("add-employee");
        return modelAndView;
    }

    @PostMapping("/add")
    protected ModelAndView processAddEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("add-employee");
            return modelAndView;
        }
        employeeService.save(employee);
        modelAndView.setViewName("redirect:/employees");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    protected ModelAndView editEmployee(@PathVariable("id") UUID id, ModelAndView modelAndView) {
        Employee employee = employeeService.findById(id);
        modelAndView.addObject("employee", employee).setViewName("edit-employee");
        return modelAndView;
    }

    protected ModelAndView processEditEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("edit-employee");
            return modelAndView;
        }
        employeeService.update(employee);
        modelAndView.setViewName("redirect:/employees");
        return modelAndView;
    }
}
