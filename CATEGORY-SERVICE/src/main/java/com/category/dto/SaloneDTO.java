package com.category.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class SaloneDTO  {

    private Long id;
    private String name;
    private List<String> images;
    private String address;
    private String phoneNumber;
    private String email;
    private String city;
    private Long owerId;
    private LocalTime openTime;
    private LocalTime closeTime;
}
