package com.home.store.repository;

import com.home.store.entities.meal.CuisineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineTypeRepository extends JpaRepository<CuisineType, Long> {
}
