package com.home.store.controller.cuisine;

import com.home.store.dto.meal.CuisineTypeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cuisineType")
public interface CuisineEndpoint {
    @PostMapping
    ResponseEntity<CuisineTypeDTO> save(@RequestBody CuisineTypeDTO cuisineTypeDTO);
}
