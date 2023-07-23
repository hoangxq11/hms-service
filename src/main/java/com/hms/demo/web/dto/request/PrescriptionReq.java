package com.hms.demo.web.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class PrescriptionReq {
    private Integer medicalRecordId;
    private List<MedicineOdPrescriptionReq> medicinesReq;
}
