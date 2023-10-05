package com.home.store.service.impl;

import com.home.dtos.meal.MealDTO;
import com.home.store.entities.meal.Meal;
import com.home.store.entities.store.Store;
import com.home.store.repository.CuisineTypeRepository;
import com.home.store.repository.MealRepository;
import com.home.store.repository.SideDishesRepository;
import com.home.store.repository.StoreRepository;
import com.home.store.service.MealService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private SideDishesRepository sideDishesRepository;

    @Autowired
    private CuisineTypeRepository cuisineTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MealDTO save(MealDTO mealDTO) {
        return null;
    }

    @Override
    public MealDTO saveTheRestaurantMeal(Long storeId, MealDTO mealDTO) {
        Store store = storeRepository.getReferenceById(storeId);
        //CuisineType cuisineType = cuisineTypeRepository.getReferenceById(mealDTO.getCuisineType().getId());
        Meal meal = modelMapper.map(mealDTO, Meal.class);
        meal.getSideDishes().forEach(sideDishes -> sideDishes.setId(sideDishesRepository.save(sideDishes).getId()));
        meal.setStore(store);
        //meal.setCuisineType(cuisineType);
        return modelMapper.map(mealRepository.save(meal),MealDTO.class);
    }
}
