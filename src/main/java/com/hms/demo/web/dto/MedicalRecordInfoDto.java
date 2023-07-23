package com.hms.demo.web.dto;

import lombok.Data;

@Data
public class MedicalRecordInfoDto {
    private Integer id;
    private Float weight;
    private Float height;
    private Float bodyTemperature;
    private Float heartbeat;
    private Float bloodPressure;
    private String detailMedical;
    private String diagnose;
    private String solution;
    private MedicalRecordDto medicalRecordDto;
}
