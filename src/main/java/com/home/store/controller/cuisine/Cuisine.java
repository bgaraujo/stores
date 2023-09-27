package com.home.store.controller.cuisine;

import com.home.store.dto.meal.CuisineTypeDTO;
import com.home.store.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cuisine implements CuisineEndpoint{

    @Autowired
    private CuisineService cuisineService;

    @Override
    public ResponseEntity<CuisineTypeDTO> save(CuisineTypeDTO cuisineTypeDTO) {
        return ResponseEntity.ok(cuisineService.save(cuisineTypeDTO));
    }
}
