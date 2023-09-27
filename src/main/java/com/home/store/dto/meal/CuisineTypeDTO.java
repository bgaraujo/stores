package com.home.store.dto.meal;

import lombok.Data;

@Data
public class CuisineTypeDTO {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
}
