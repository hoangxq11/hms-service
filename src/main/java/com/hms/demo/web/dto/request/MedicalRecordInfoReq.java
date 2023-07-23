package com.hms.demo.web.dto.request;

import lombok.Data;

@Data
public class MedicalRecordInfoReq {
    private Float weight;
    private Float height;
    private Float bodyTemperature;
    private Float heartbeat;
    private Float bloodPressure;
    private String detailMedical;
    private String diagnose;
    private String solution;
    private Integer medicalRecordId;
}
