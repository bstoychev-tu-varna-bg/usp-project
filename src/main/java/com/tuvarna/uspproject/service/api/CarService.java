package com.tuvarna.uspproject.service.api;

import com.tuvarna.uspproject.model.Car;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public interface CarService {
    void save(Car car);
    void update(Car car);
    Car findById(UUID id);
    Collection<Car> findAll();
    Collection<Car> findByCriteria(Collection<String> criteria);
}
