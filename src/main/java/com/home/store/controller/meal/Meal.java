package com.home.store.controller.meal;

import com.home.store.dto.meal.MealDTO;
import com.home.store.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Meal implements MealEndpoint{

    @Autowired
    MealService mealService;
    @Override
    public ResponseEntity<MealDTO> save(Long storeId, MealDTO mealDTO) {
        return ResponseEntity.ok(mealService.saveTheRestaurantMeal(storeId, mealDTO));
    }
}
