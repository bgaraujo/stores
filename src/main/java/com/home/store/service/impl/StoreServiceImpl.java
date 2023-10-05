package com.home.store.service.impl;

import com.home.dtos.address.AddressDTO;
import com.home.dtos.document.DocumentDTO;
import com.home.dtos.store.StoreDTO;
import com.home.store.entities.store.Document;
import com.home.store.entities.store.Store;
import com.home.store.repository.DocumentRepository;
import com.home.store.repository.OpeningHoursRepository;
import com.home.store.repository.StoreRepository;
import com.home.store.service.AddressService;
import com.home.store.service.DocumentService;
import com.home.store.service.StoreService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private OpeningHoursRepository openingHoursRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public StoreDTO save(StoreDTO storeDTO) {
        Store store = modelMapper.map(storeDTO, Store.class);
        store.getOpeningHours().forEach(openingHours -> openingHours.setId(openingHoursRepository.save(openingHours).getId()));

        AddressDTO addressDTO = saveAddress(store, storeDTO);
        List<DocumentDTO> documentDTOList = saveDocuments(store, storeDTO);

        storeDTO = modelMapper.map(storeRepository.save(store), StoreDTO.class);
        storeDTO.setAddress(addressDTO);
        storeDTO.setDocuments(documentDTOList);

        return storeDTO;
    }

    private AddressDTO saveAddress(Store store, StoreDTO storeDTO){
        AddressDTO addressDTO = addressService.save(storeDTO.getAddress());
        store.setAddressId(addressDTO.getId());
        return addressDTO;
    }

    private List<DocumentDTO> saveDocuments(Store store, StoreDTO storeDTO){
        List<DocumentDTO> documentDTOList = documentService.saveList(storeDTO.getDocuments());
        List<Document> documents = new ArrayList<>();
        documentDTOList.forEach(documentDTO -> {
            Document document = new Document();
            document.setIdDocument(documentDTO.getId());
            documentRepository.save(document);
            documents.add(document);
        });
        store.setDocuments(documents);
        return documentDTOList;
    }
}
