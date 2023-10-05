package com.home.store.entities.store;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Document {

    @Id
    private Long idDocument;
}
