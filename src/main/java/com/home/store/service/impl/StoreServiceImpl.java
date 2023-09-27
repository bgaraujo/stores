package com.home.store.service.impl;

import com.home.store.dto.store.StoreDTO;
import com.home.store.entities.store.Store;
import com.home.store.repository.*;
import com.home.store.service.StoreService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private OpeningHoursRepository openingHoursRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public StoreDTO save(StoreDTO storeDTO) {
        Store store = modelMapper.map(storeDTO, Store.class);
        store.getOpeningHours().forEach(openingHours -> openingHours.setId(openingHoursRepository.save(openingHours).getId()));
        store.getDocuments().forEach(document -> document.setId(documentRepository.save(document).getId()));
        store.getAddress().getLocation().setId(locationRepository.save(store.getAddress().getLocation()).getId());
        store.getAddress().setId(addressRepository.save(store.getAddress()).getId());

        Store teste = storeRepository.save(store);
        return modelMapper.map(teste, StoreDTO.class);
    }
}
