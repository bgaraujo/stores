package com.home.store.entities.store;

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
    @OneToMany
    private List<Document> documents;
    private Long addressId;
    private Long deliverTimeInMinutes;
}
