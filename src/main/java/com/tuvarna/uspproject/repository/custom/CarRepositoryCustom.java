package com.tuvarna.uspproject.repository.custom;

import com.tuvarna.uspproject.model.Car;

import java.util.Collection;
import java.util.Set;

public interface CarRepositoryCustom {

    Collection<Car> findByCriteria(Set<String> criteria);
}
