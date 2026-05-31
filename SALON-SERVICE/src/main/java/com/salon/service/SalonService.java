package com.salon.service;

import com.salon.model.Salon;
import com.salon.playload.dto.SaloneDTO;
import com.salon.playload.dto.UserDTO;

import java.util.List;

public interface SalonService {

    Salon createSalon(SaloneDTO saloneDTO , UserDTO user);
    Salon updateSalon(SaloneDTO saloneDTO, UserDTO user, Long salonId);
    Salon getSalonById(Long salonId);
    List<Salon> getAllSalons();
    void deleteSalon(Long salonId);

    Salon getSalonByOwerId(Long ownerId);

    List<Salon> searchsaloneByCity(String city);

    List<Salon> searchsaloneByCityAndName(String city, String name);

    List<Salon> searchsaloneByCityAndNameAndAddress(String city, String name, String address);
}
