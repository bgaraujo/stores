package com.home.store.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.home.dtos.address.AddressDTO;
import com.home.store.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AddressServiceImpl implements AddressService {

    @Value("${api.rest.address.host}")
    private String host;
    @Value("${api.rest.address.url}")
    private String url;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Gson gson;

    @Override
    public AddressDTO save(AddressDTO addressDTO){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(host + url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(addressDTO)))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body().toString(), AddressDTO.class);
        } catch (JsonSyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
