package com.home.store.dto.address;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LocationDTO {
    private Long id;
    private BigDecimal lat;
    private BigDecimal lng;
}
