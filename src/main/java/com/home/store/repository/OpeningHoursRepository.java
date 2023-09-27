package com.home.store.repository;

import com.home.store.entities.store.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> {
}
