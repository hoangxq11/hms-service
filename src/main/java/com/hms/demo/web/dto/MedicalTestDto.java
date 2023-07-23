package com.hms.demo.web.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MedicalTestDto {
    private Integer id;
    private String name;
    private Float totalPrice;
    private LocalDateTime time;
    private Integer medicalRecordId;
    private List<ServicesOfMedicalTestDto> services;
}