package com.salon.controller;

import com.salon.mapper.SalonMapper;
import com.salon.model.Salon;
import com.salon.playload.dto.SaloneDTO;
import com.salon.playload.dto.UserDTO;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping("/create")
    public ResponseEntity<SaloneDTO> createSalon(@RequestBody SaloneDTO saloneDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Salon salon = salonService.createSalon(saloneDTO, userDTO);

        SaloneDTO salonDTO1 = SalonMapper.mapTODTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @GetMapping("/get/salons")
    public ResponseEntity<List<SaloneDTO>> getAllSalon()
    {
        List<Salon> salons = salonService.getAllSalons();
        List<SaloneDTO> saloneDTOSList = salons.stream()
                .map(SalonMapper::mapTODTO).toList();

        return  ResponseEntity.ok(saloneDTOSList);
    }

    @GetMapping("/get/salon/{id}")
    public ResponseEntity<SaloneDTO> getSaloneById(@PathVariable Long id) throws Exception {
        Salon salon = salonService.getSalonById(id);
        if(salon == null){
            throw new Exception("Salon Not Found");
        }
        SaloneDTO salonDTO1 = SalonMapper.mapTODTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SaloneDTO> updateSalone(
            @PathVariable Long id,
            @RequestBody SaloneDTO saloneDTO) throws Exception {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Salon salon = salonService.updateSalon(saloneDTO, userDTO, id);

        return ResponseEntity.ok(SalonMapper.mapTODTO(salon));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSalon(@PathVariable Long id) throws Exception {
        salonService.deleteSalon(id);
        return ResponseEntity.ok("Salon deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<SaloneDTO>> searchSalon(

            @RequestParam(required = false) String city,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address
    ) {

        List<Salon> salons;

        if (city != null && name != null && address != null) {
            salons = salonService.searchsaloneByCityAndNameAndAddress(city, name, address);

        } else if (city != null && name != null) {
            salons = salonService.searchsaloneByCityAndName(city, name);

        } else if (city != null) {
            salons = salonService.searchsaloneByCity(city);

        } else {
            salons = salonService.getAllSalons();
        }

        List<SaloneDTO> saloneDTOSList = salons.stream()
                .map(SalonMapper::mapTODTO)
                .toList();

        return ResponseEntity.ok(saloneDTOSList);
    }
}
