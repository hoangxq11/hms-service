package com.hms.demo.service;

import com.hms.demo.web.dto.MedicalTestDto;
import com.hms.demo.web.dto.request.MedicalTestReq;

public interface MedicalTestService {
    void createMedicalTest(MedicalTestReq medicalTestReq);

    MedicalTestDto getByMedicalRecord(Integer medicalRecordId);
}
