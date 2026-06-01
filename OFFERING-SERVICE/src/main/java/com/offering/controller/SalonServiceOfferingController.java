package com.offering.controller;

import com.offering.dto.CategoryDTO;
import com.offering.dto.SaloneDTO;
import com.offering.dto.ServiceDTO;
import com.offering.model.ServiceOffering;
import com.offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/salon/services")
@RequiredArgsConstructor
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
//            @RequestParam Long salonId,
            @RequestParam Long categoryId,
            @RequestBody ServiceDTO serviceDTO
    ) {

        // Build DTOs (clean + dynamic)
        SaloneDTO saloneDTO = new SaloneDTO();
        saloneDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering service = serviceOfferingService
                .saveServiceOffering(saloneDTO, categoryDTO, serviceDTO);

        return ResponseEntity.ok(service);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long serviceId,
            @RequestBody ServiceOffering serviceOffering
    ) {
        ServiceOffering updatedService = serviceOfferingService
                .updateService(serviceId, serviceOffering);

        return ResponseEntity.ok(updatedService);
    }
}