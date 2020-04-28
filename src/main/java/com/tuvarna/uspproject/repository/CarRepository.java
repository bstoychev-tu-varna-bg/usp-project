package com.tuvarna.uspproject.repository;

import com.tuvarna.uspproject.model.Car;
import com.tuvarna.uspproject.repository.custom.CarRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID>, CarRepositoryCustom {
}
