package com.salon.service.impl;

import com.salon.model.Salon;
import com.salon.playload.dto.SaloneDTO;
import com.salon.playload.dto.UserDTO;
import com.salon.repository.SalonRepository;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon updateSalon(SaloneDTO salone, UserDTO user, Long salonId) throws Exception {
        Salon existingSalon = salonRepository.findById(salonId).orElse(null);
        if (existingSalon != null && salone.getOwerId().equals(user.getId())){
            existingSalon.setCity(salone.getCity());
            existingSalon.setAddress(salone.getAddress());
            existingSalon.setName(salone.getName());
            existingSalon.setImages(salone.getImages());
            existingSalon.setEmail(salone.getEmail());
            existingSalon.setCloseTime(salone.getCloseTime());
            existingSalon.setOpenTime(salone.getOpenTime());
            existingSalon.setPhoneNumber(salone.getPhoneNumber());
            existingSalon.setOwerId(salone.getOwerId()
            );

        }
        throw new Exception("Salone not found");

    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if(salon == null){
            throw new Exception("Salone not preset");
        }
        return  salon;
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public void deleteSalon(Long salonId) {
        salonRepository.deleteById(salonId);
    }

    @Override
    public Salon getSalonByOwerId(Long ownerId) {
        return salonRepository.getSalonByOwerId(ownerId);
    }

    @Override
    public List<Salon> searchsaloneByCity(String city) {
        return salonRepository.searchSalon(city);
    }

    @Override
    public List<Salon> searchsaloneByCityAndName(String city, String name) {
        return salonRepository.searchByCityAndName(city, name);
    }

    @Override
    public List<Salon> searchsaloneByCityAndNameAndAddress(String city, String name, String address) {
        return salonRepository.searchByCityAndNameAndAddress(city,address, name);
    }

    @Override
    public Salon createSalon(SaloneDTO req, UserDTO user) {
        Salon salon =  new Salon();
        salon.setName(req.getName());
        salon.setImages(req.getImages());
        salon.setAddress(req.getAddress());
        salon.setPhoneNumber(req.getPhoneNumber());
        salon.setCity(req.getCity());
        salon.setOwerId(user.getId());
        salon.setOpenTime(req.getOpenTime());
        salon.setCloseTime(req.getCloseTime());
        salon.setEmail(req.getEmail());
        return salonRepository.save(salon);
    }




}
