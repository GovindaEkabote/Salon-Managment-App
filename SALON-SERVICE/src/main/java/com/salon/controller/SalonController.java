package com.salon.controller;

import com.salon.mapper.SalonMapper;
import com.salon.model.Salon;
import com.salon.playload.dto.SaloneDTO;
import com.salon.playload.dto.UserDTO;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
