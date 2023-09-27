package com.home.store.entities.meal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SideDishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Meal meal;
}
