package com.home.store.service.impl;

import com.home.dtos.meal.CuisineTypeDTO;
import com.home.store.entities.meal.CuisineType;
import com.home.store.repository.CuisineTypeRepository;
import com.home.store.service.CuisineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuisineServiceImpl implements CuisineService {
    @Autowired
    private CuisineTypeRepository cuisineTypeRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CuisineTypeDTO save(CuisineTypeDTO cuisineTypeDTO) {
        CuisineType cuisineType = modelMapper.map(cuisineTypeDTO, CuisineType.class);
        return modelMapper.map(cuisineTypeRepository.save(cuisineType),CuisineTypeDTO.class);
    }
}
