package com.home.store.service.impl;

import com.home.store.dto.address.AddressDTO;
import com.home.store.entities.address.Address;
import com.home.store.repository.AddressRepository;
import com.home.store.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address = addressRepository.save(address);
        return modelMapper.map(address, AddressDTO.class);
    }
}
