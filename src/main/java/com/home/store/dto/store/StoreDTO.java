package com.home.store.dto.store;

import com.home.store.dto.address.AddressDTO;
import com.home.store.dto.document.DocumentDTO;
import com.home.store.entities.address.Address;
import com.home.store.entities.document.Document;
import com.home.store.entities.store.OpeningHours;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
public class StoreDTO {
    private Long id;
    private String name;
    private List<OpeningHoursDTO> openingHours;
    private List<DocumentDTO> documents;
    private AddressDTO address;
    private Long deliverTimeInMinutes;
}
