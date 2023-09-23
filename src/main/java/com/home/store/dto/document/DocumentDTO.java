package com.home.store.dto.document;

import com.home.store.enums.DocumentType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DocumentDTO {
    private DocumentType documentType;
    private String number;
    private LocalDate expirationDate;
}
