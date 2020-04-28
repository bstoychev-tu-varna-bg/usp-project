package com.tuvarna.uspproject.repository;

import com.tuvarna.uspproject.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Query("FROM Brand WHERE name = ?1")
    Brand findByName(String name);
}
