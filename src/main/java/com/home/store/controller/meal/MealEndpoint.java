package com.home.store.controller.meal;

import com.home.dtos.meal.MealDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/meal")
public interface MealEndpoint {

    @PostMapping("/{storeId}")
    ResponseEntity<MealDTO> save(@PathVariable("storeId") Long storeId, @RequestBody MealDTO mealDTO);
}
