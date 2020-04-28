package com.tuvarna.uspproject.service.api;

import com.tuvarna.uspproject.model.Car;

import java.util.Collection;
import java.util.UUID;

public interface CarService {
    Car save(Car car);
    Collection<Car> findAll();
    Collection<Car> findByCriteria(Collection<String> criteria);
}
