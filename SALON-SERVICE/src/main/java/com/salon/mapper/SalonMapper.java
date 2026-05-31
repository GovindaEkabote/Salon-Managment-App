package com.salon.mapper;

import com.salon.model.Salon;
import com.salon.playload.dto.SaloneDTO;

public class SalonMapper {


    public static SaloneDTO mapTODTO(Salon salon) {
        SaloneDTO dto = new SaloneDTO();

        dto.setId(salon.getId());
        dto.setName(salon.getName());
        dto.setAddress(salon.getAddress());
        dto.setCity(salon.getCity());
        dto.setPhoneNumber(salon.getPhoneNumber());
        dto.setEmail(salon.getEmail());
        dto.setOwerId(salon.getOwerId());
        dto.setOpenTime(salon.getOpenTime());
        dto.setCloseTime(salon.getCloseTime());
        dto.setImages(salon.getImages());

        return dto;
    }
}