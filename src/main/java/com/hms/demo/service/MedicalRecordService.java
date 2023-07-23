package com.hms.demo.service;

import com.hms.demo.web.dto.MedicalRecordDto;
import com.hms.demo.web.dto.MedicalRecordInfoDto;
import com.hms.demo.web.dto.request.MedicalRecordInfoReq;
import com.hms.demo.web.dto.request.MedicalRecordReq;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordDto getMedicalRecordById(Integer medicalRecordId);

    void createMedicalRecord(MedicalRecordReq medicalRecordReq);

    List<MedicalRecordDto> getMedicalRecords();

    void createMedicalRecordInfo(MedicalRecordInfoReq medicalRecordReq);

    List<MedicalRecordDto> getMedicalRecordsOfDoctor(String doctorUsername);

    MedicalRecordInfoDto getMedicalRecordInfo(Integer medicalRecordId);

    void updateStatus(Integer medicalRecordId, String status);

    List<MedicalRecordDto> getMedicalRecordsOfPatient(String patientUsername);

    void updatePaymentStatus(Integer medicalRecordId, String paymentStatus);
}
