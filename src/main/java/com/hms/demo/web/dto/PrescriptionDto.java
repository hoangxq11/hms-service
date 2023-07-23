package com.hms.demo.web.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PrescriptionDto {
    private Integer id;
    private Integer medicalRecordId;
    private LocalDateTime time;
    private List<MedicineOfPrescriptionDto> medicines;
}
