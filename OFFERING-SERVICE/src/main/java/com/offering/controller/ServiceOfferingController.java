package com.offering.controller;

import com.offering.dto.CategoryDTO;
import com.offering.dto.SaloneDTO;
import com.offering.dto.ServiceDTO;
import com.offering.model.ServiceOffering;
import com.offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    // ✅ Create Service
    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO) {

        SaloneDTO saloneDTO = new SaloneDTO();
        saloneDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering service = serviceOfferingService
                .saveServiceOffering(saloneDTO, categoryDTO, serviceDTO);

        return ResponseEntity.ok(service);
    }

    // ✅ Update Service
    @PutMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering service) {

        return ResponseEntity.ok(
                serviceOfferingService.updateService(id, service)
        );
    }

    // ✅ Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(serviceOfferingService.getServiceById(id));
    }

    // ✅ Get by Salon + Category
    @GetMapping
    public ResponseEntity<Set<ServiceOffering>> getServices(
            @RequestParam Long salonId,
            @RequestParam Long categoryId) {

        return ResponseEntity.ok(
                serviceOfferingService.getAllServiceBySalonId(salonId, categoryId)
        );
    }

    // ✅ Get by IDs
    @PostMapping("/bulk")
    public ResponseEntity<Set<ServiceOffering>> getServicesByIds(
            @RequestBody Set<Long> ids) {

        return ResponseEntity.ok(
                serviceOfferingService.getServicesByIds(ids)
        );
    }
}