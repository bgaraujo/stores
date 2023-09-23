package com.home.store.dto.store;

import com.home.store.dto.address.AddressDTO;
import com.home.store.dto.document.DocumentDTO;
import lombok.Data;

import java.util.List;

@Data
public class StoreDTO {
    private String name;
    private List<DocumentDTO> documents;
    private AddressDTO address;
}
