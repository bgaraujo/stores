package com.home.store.controller.store;

import com.home.dtos.store.StoreDTO;
import com.home.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Store implements StoreEndpoint{

    @Autowired
    private StoreService storeService;

    @Override
    public ResponseEntity<StoreDTO> create(StoreDTO storeDTO) {
        return ResponseEntity.ok(storeService.save(storeDTO));
    }
}
