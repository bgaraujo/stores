package com.home.store.controller.store;

import com.home.store.dto.store.StoreDTO;
import com.home.store.dto.store.StoreResponseDTO;
import com.home.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


public class Store implements StoreEndpoint{

    @Autowired
    private StoreService storeService;

    @Override
    public ResponseEntity<StoreResponseDTO> create(StoreDTO storeDTO) {
        storeService.save(storeDTO);
        return ResponseEntity.ok(new StoreResponseDTO());
    }
}
