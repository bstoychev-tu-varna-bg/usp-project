package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.exception.NotExistingCarException;
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
import java.util.UUID;

@Service
public final class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelService modelService;

    @Override
    public void save(Car car) {
        Model model = modelService.save(car.getModel());
        car.setModel(model);
        carRepository.save(car);
    }

    @Override
    public void update(Car car) {
        if(isExistingCar(car))
            carRepository.save(car);
        else
            throw new NotExistingCarException("Car doesn't exist!");
    }

    @Override
    public Car findById(UUID id) {
        return carRepository.findById(id).orElseThrow(()->
                new NotExistingCarException("Car doesn't exist!"));
    }

    @Override
    public Collection<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Collection<Car> findByCriteria(Collection<String> criteria) {
        return carRepository.findByCriteria(convertCriteriaToSet(criteria));
    }

    private boolean isExistingCar(Car car){
        return carRepository.existsById(car.getId());
    }

    private Set<String> convertCriteriaToSet(Collection<String> criteria){
        return new HashSet<>(criteria);
    }
}
