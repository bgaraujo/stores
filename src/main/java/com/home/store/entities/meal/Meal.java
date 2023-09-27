package com.home.store.entities.meal;

import com.home.store.entities.store.Store;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private CuisineType cuisineType;
    private BigDecimal price;
    private String description;
    private Boolean available;
    @OneToMany
    private List<SideDishes> sideDishes;

    @ManyToOne
    private Store store;

}
