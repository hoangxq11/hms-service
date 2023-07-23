package com.hms.demo.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalRecordDto {
    private Integer id;
    private LocalDateTime time;
    private PatientDto patientDto;
    private StaffDto staffDto;
    private String status;
    private String paymentStatus;
}