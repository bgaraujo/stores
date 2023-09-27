package com.home.store.entities.store;

import com.home.store.entities.address.Address;
import com.home.store.entities.document.Document;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<OpeningHours> openingHours;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
    private List<Document> documents;
    @OneToOne
    private Address address;
    private Long deliverTimeInMinutes;
}
