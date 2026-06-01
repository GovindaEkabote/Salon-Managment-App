package com.offering.service.impl;

import com.offering.dto.CategoryDTO;
import com.offering.dto.SaloneDTO;
import com.offering.dto.ServiceDTO;
import com.offering.model.ServiceOffering;
import com.offering.repository.ServiceOfferingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements com.offering.service.ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;


    @Override
    public ServiceOffering saveServiceOffering(SaloneDTO saloneDTO,
                                               CategoryDTO categoryDTO,
                                               ServiceDTO serviceDTO) {

        // Basic validation
        if (!serviceDTO.getSalonId().equals(saloneDTO.getId())) {
            throw new IllegalArgumentException("Salon ID mismatch");
        }

        if (!serviceDTO.getCategory().equals(categoryDTO.getId())) {
            throw new IllegalArgumentException("Category ID mismatch");
        }

        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setImages(serviceDTO.getImages());
        serviceOffering.setSalonId(saloneDTO.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering updatedService) {

        ServiceOffering existingService = serviceOfferingRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        existingService.setName(updatedService.getName());
        existingService.setDescription(updatedService.getDescription());
        existingService.setPrice(updatedService.getPrice());
        existingService.setDuration(updatedService.getDuration());
        existingService.setImages(updatedService.getImages());

        return serviceOfferingRepository.save(existingService);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId) {
        Set<ServiceOffering> serviceOfferings = serviceOfferingRepository.findBySalonId(salonId);
        return serviceOfferings.stream()
                .filter(service -> service.getCategoryId().equals(categoryId))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> serviceOfferings= serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(serviceOfferings);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        ServiceOffering serviceOffering= serviceOfferingRepository.findById(id)
                .orElse(null);
        if (serviceOffering == null){
            throw new Exception("Service not found");
        }
        return serviceOffering;
    }

}
