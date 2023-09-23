package com.home.store.entities;

import com.home.store.dto.address.AddressDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
    private List<Document> documents;
    @OneToOne(mappedBy = "store")
    private Address address;
}
