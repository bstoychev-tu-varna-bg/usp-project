package com.tuvarna.uspproject.controller;

import com.tuvarna.uspproject.model.Car;
import com.tuvarna.uspproject.service.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Controller
@RequestMapping("/cars")
public final class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    protected ModelAndView findAllCars(ModelAndView modelAndView) {
        Collection<Car> cars = carService.findAll();
        modelAndView.addObject("cars", cars).setViewName("view-cars");
        return modelAndView;
    }

    @GetMapping("/search")
    protected ModelAndView findCarsByCriteria(ModelAndView modelAndView) {
        modelAndView.addObject("criteria", new ArrayList<String>()).setViewName("search-car");
        return modelAndView;
    }

    @GetMapping("/search-created")
    protected ModelAndView processFindCarsByCriteria(@ModelAttribute("criteria") Collection<String> criteria, ModelAndView modelAndView) {
        Collection<Car> cars = carService.findByCriteria(criteria);
        modelAndView.addObject("cars", cars).setViewName("view-cars");
        return modelAndView;
    }

    @GetMapping("/add")
    protected ModelAndView addCar(ModelAndView modelAndView) {
        modelAndView.addObject("car", new Car()).setViewName("add-car");
        return modelAndView;
    }

    @PostMapping("/add")
    protected ModelAndView processAddCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult, ModelAndView modelAndView) {
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("add-car");
            return modelAndView;
        }
        carService.save(car);
        modelAndView.setViewName("redirect:/cars");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    protected ModelAndView editCar(@PathVariable("id") UUID id, ModelAndView modelAndView) {
        Car car = carService.findById(id);
        modelAndView.addObject("car", car).setViewName("edit-car");
        return modelAndView;
    }

    protected ModelAndView processEditCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult, ModelAndView modelAndView) {
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("edit-car");
            return modelAndView;
        }
        carService.update(car);
        modelAndView.setViewName("redirect:/cars");
        return modelAndView;
    }

}
