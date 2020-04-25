package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.model.Car;
import com.tuvarna.uspproject.model.Model;
import com.tuvarna.uspproject.repository.CarRepository;
import com.tuvarna.uspproject.service.api.CarService;
import com.tuvarna.uspproject.service.api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public final class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelService modelService;

    @Override
    public Car save(Car car) {
        Model model = modelService.save(car.getModel());
        car.setModel(model);
        carRepository.save(car);
        return car;
    }

    @Override
    public Collection<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Collection<Car> findByCriteria(Collection<String> criteria) {
        return carRepository.findByCriteria(convertCriteriaToSet(criteria));
    }

    private Set<String> convertCriteriaToSet(Collection<String> criteria) {
        return new HashSet<>(criteria);
    }
}
