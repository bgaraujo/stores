package com.home.store.service;

import com.home.store.dto.meal.MealDTO;

public interface MealService {

    MealDTO save(MealDTO mealDTO);

    MealDTO saveTheRestaurantMeal(Long restaurantId, MealDTO mealDTO);



}
