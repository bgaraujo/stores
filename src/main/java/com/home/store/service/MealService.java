package com.home.store.service;


import com.home.dtos.meal.MealDTO;

public interface MealService {

    MealDTO save(MealDTO mealDTO);

    MealDTO saveTheRestaurantMeal(Long restaurantId, MealDTO mealDTO);



}
