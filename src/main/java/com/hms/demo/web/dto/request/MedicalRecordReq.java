package com.hms.demo.web.dto.request;

import lombok.Data;

@Data
public class MedicalRecordReq {
    private Integer patientId;
    private Integer staffId;
}