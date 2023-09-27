package com.home.store.controller.store;

import com.home.store.dto.store.StoreDTO;
import com.home.store.dto.store.StoreResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/store")
public interface StoreEndpoint {

    @PostMapping
    ResponseEntity<StoreDTO> create(@RequestBody StoreDTO storeDTO);
}
