package com.home.store.controller.store;

import com.home.dtos.store.StoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/store")
public interface StoreEndpoint {

    @PostMapping
    ResponseEntity<StoreDTO> create(@RequestBody StoreDTO storeDTO);
}
