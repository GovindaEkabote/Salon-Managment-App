package com.offering.dto;

import lombok.Data;

@Data
public class CreateServiceRequest {
    private ServiceDTO serviceDTO;
    private SaloneDTO saloneDTO;
    private CategoryDTO categoryDTO;
}