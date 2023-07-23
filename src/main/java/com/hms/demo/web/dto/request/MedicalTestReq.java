package com.hms.demo.web.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class MedicalTestReq {
    private Integer medicalRecordId;
    private List<ServicesOfMedicalTestReq> services;
}
