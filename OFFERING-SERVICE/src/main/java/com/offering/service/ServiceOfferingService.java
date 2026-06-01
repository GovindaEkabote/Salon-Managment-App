package com.offering.service;

import com.offering.dto.CategoryDTO;
import com.offering.dto.SaloneDTO;
import com.offering.dto.ServiceDTO;
import com.offering.model.ServiceOffering;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ServiceOfferingService {

    ServiceOffering saveServiceOffering(SaloneDTO saloneDTO, CategoryDTO categoryDTO, ServiceDTO serviceDTO);
    ServiceOffering updateService(Long serviceId, ServiceOffering service);
    Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId);
    Set<ServiceOffering> getServicesByIds(Set<Long> ids);
    ServiceOffering getServiceById(Long id) throws Exception;
}
