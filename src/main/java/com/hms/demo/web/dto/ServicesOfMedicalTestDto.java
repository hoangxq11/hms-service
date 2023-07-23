package com.hms.demo.web.dto;

import lombok.Data;

@Data
public class ServicesOfMedicalTestDto {
    private Integer id;
    private ServicesDto serviceDto;
    private Integer quantity;
}