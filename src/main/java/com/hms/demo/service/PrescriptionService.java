package com.hms.demo.service;

import com.hms.demo.web.dto.PrescriptionDto;
import com.hms.demo.web.dto.request.PrescriptionReq;

public interface PrescriptionService {
    void createPrescription(PrescriptionReq prescriptionReq);

    PrescriptionDto getPrescriptionById(Integer prescriptionId);

    PrescriptionDto getPrescriptionOfMedicalRecord(Integer medicalRecordId);
}
