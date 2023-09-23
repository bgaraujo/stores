package com.home.store.service.impl;

import com.home.store.dto.store.StoreDTO;
import com.home.store.entities.Store;
import com.home.store.repository.StoreRepository;
import com.home.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Override
    public StoreDTO save(StoreDTO storeD) {
        Store store = new Store();
        storeRepository.save(store);
        return null;
    }
}
