package com.home.store.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import com.home.dtos.document.DocumentDTO;
import com.home.store.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Value("${api.rest.personal-info.host}")
    private String host;
    @Value("${api.rest.personal-info.document-list.url}")
    private String url;
    @Autowired
    private Gson gson;
    @Override
    public List<DocumentDTO> saveList(List<DocumentDTO> documentDTOList) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(host + url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(documentDTOList)))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JsonArray jsonArray = gson.fromJson(response.body().toString(), JsonArray.class);
            List<DocumentDTO> documentDTOS = new ArrayList<>();
            jsonArray.forEach(jsonElement -> documentDTOS.add(gson.fromJson(jsonElement, DocumentDTO.class)));
            return documentDTOS;
        } catch (JsonSyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
