package com.home.store.service;

import com.home.dtos.document.DocumentDTO;

import java.util.List;

public interface DocumentService {
    List<DocumentDTO> saveList(List<DocumentDTO> documentDTO);
}
