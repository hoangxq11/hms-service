package com.hms.demo.service.impl;

import com.hms.demo.model.MedicalReport;
import com.hms.demo.model.MedicineOfPrescription;
import com.hms.demo.model.Prescription;
import com.hms.demo.model.Services;
import com.hms.demo.repository.MedicalRecordRepository;
import com.hms.demo.repository.MedicineOfPrescriptionRepository;
import com.hms.demo.repository.MedicineRepository;
import com.hms.demo.repository.PrescriptionRepository;
import com.hms.demo.service.PrescriptionService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.MedicineDto;
import com.hms.demo.web.dto.MedicineOfPrescriptionDto;
import com.hms.demo.web.dto.PrescriptionDto;
import com.hms.demo.web.dto.request.MedicineOdPrescriptionReq;
import com.hms.demo.web.dto.request.PrescriptionReq;
import com.hms.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicineRepository medicineRepository;
    private final MedicineOfPrescriptionRepository medicineOfPrescriptionRepository;
    private final MappingHelper mappingHelper;

    @Override
    public void createPrescription(PrescriptionReq prescriptionReq) {
        if (prescriptionRepository.findByMedicalRecord_Id(prescriptionReq.getMedicalRecordId()).isPresent()) {
            deleteOldData(prescriptionReq);
        }

        var medicalRecord = medicalRecordRepository.findById(prescriptionReq.getMedicalRecordId())
                .orElseThrow(() -> new EntityNotFoundException(MedicalReport.class.getName()
                        , prescriptionReq.getMedicalRecordId().toString()));
        var prescription = mappingHelper.map(prescriptionReq, Prescription.class);
        prescription.setTime(LocalDateTime.now());
        prescription.setMedicalRecord(medicalRecord);
        prescriptionRepository.save(prescription);

        List<MedicineOfPrescription> medicines = new ArrayList<>();
        for (MedicineOdPrescriptionReq item : prescriptionReq.getMedicinesReq()) {
            var medicineOfPres = mappingHelper.map(item, MedicineOfPrescription.class);
            var medicine = medicineRepository.findById(item.getMedicineId())
                    .orElseThrow(() -> new EntityNotFoundException(Services.class.getName(), item.getMedicineId().toString()));
            medicineOfPres.setMedicine(medicine);
            medicineOfPres.setPrescription(prescription);
            medicines.add(medicineOfPres);
        }
        medicineOfPrescriptionRepository.saveAll(medicines);
    }

    @Override
    public PrescriptionDto getPrescriptionById(Integer prescriptionId) {
        var prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new EntityNotFoundException(Prescription.class.getName()
                        , prescriptionId.toString()));
        var prescriptionDto = mappingHelper.map(prescription, PrescriptionDto.class);
        var medicines = medicineOfPrescriptionRepository.findByPrescription_Id(prescriptionId)
                .stream().map(e -> {
                    var res = mappingHelper.map(e, MedicineOfPrescriptionDto.class);
                    res.setMedicineDto(mappingHelper.map(e.getMedicine(), MedicineDto.class));
                    return res;
                }).collect(Collectors.toList());
        prescriptionDto.setMedicines(medicines);
        prescriptionDto.setMedicalRecordId(prescription.getMedicalRecord().getId());
        return prescriptionDto;
    }

    @Override
    public PrescriptionDto getPrescriptionOfMedicalRecord(Integer medicalRecordId) {
        var prescription = prescriptionRepository.findByMedicalRecord_Id(medicalRecordId)
                .orElseThrow(() -> new EntityNotFoundException(Prescription.class.getName()
                        , medicalRecordId.toString()));
        var prescriptionDto = mappingHelper.map(prescription, PrescriptionDto.class);
        var medicines = medicineOfPrescriptionRepository
                .findByPrescription_Id(prescription.getId())
                .stream().map(e -> {
                    var res = mappingHelper.map(e, MedicineOfPrescriptionDto.class);
                    res.setMedicineDto(mappingHelper.map(e.getMedicine(), MedicineDto.class));
                    return res;
                }).collect(Collectors.toList());
        prescriptionDto.setMedicines(medicines);
        prescriptionDto.setMedicalRecordId(prescription.getMedicalRecord().getId());
        return prescriptionDto;
    }

    private void deleteOldData(PrescriptionReq prescriptionReq) {
        var prescription = prescriptionRepository.findByMedicalRecord_Id(prescriptionReq.getMedicalRecordId())
                .orElseThrow(() -> new EntityNotFoundException(Prescription.class.getName()
                        , prescriptionReq.getMedicalRecordId().toString()));
        var medicines = medicineOfPrescriptionRepository.findByPrescription_Id(prescription.getId());
        medicineOfPrescriptionRepository.deleteAll(medicines);
        prescriptionRepository.delete(prescription);
    }
}
