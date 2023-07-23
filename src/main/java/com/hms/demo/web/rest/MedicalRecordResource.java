package com.hms.demo.web.rest;

import com.hms.demo.service.MedicalRecordService;
import com.hms.demo.web.dto.request.MedicalRecordInfoReq;
import com.hms.demo.web.dto.request.MedicalRecordReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-record")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MedicalRecordResource {
    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<?> getMedicalRecords() {
        return ResponseUtils.ok(medicalRecordService.getMedicalRecords());
    }

    @GetMapping("/doctor/{doctorUsername}")
    public ResponseEntity<?> getMedicalRecordsOfDoctor(@PathVariable String doctorUsername) {
        return ResponseUtils.ok(medicalRecordService.getMedicalRecordsOfDoctor(doctorUsername));
    }

    @GetMapping("/patient/{patientUsername}")
    public ResponseEntity<?> getMedicalRecordsOfPatient(@PathVariable String patientUsername) {
        return ResponseUtils.ok(medicalRecordService.getMedicalRecordsOfPatient(patientUsername));
    }

    @GetMapping("/{medicalRecordId}")
    public ResponseEntity<?> getMedicalRecordById(@PathVariable Integer medicalRecordId) {
        return ResponseUtils.ok(medicalRecordService.getMedicalRecordById(medicalRecordId));
    }

    @PostMapping("/create-medical-record")
    public ResponseEntity<?> createMedicalRecord(@RequestBody MedicalRecordReq medicalRecordReq) {
        medicalRecordService.createMedicalRecord(medicalRecordReq);
        return ResponseUtils.created();
    }

    @PostMapping("/create-medical-record-info")
    public ResponseEntity<?> createMedicalRecordInfo(@RequestBody MedicalRecordInfoReq medicalRecordReq) {
        medicalRecordService.createMedicalRecordInfo(medicalRecordReq);
        return ResponseUtils.created();
    }

    @GetMapping("/info/{medicalRecordId}")
    public ResponseEntity<?> getMedicalRecordInfo(@PathVariable Integer medicalRecordId) {
        return ResponseUtils.ok(medicalRecordService.getMedicalRecordInfo(medicalRecordId));
    }

    @PutMapping("/update-status/{medicalRecordId}")
    public ResponseEntity<?> updateStatus(@PathVariable Integer medicalRecordId, @RequestBody String status) {
        medicalRecordService.updateStatus(medicalRecordId, status);
        return ResponseUtils.ok("Updated");
    }

    @PutMapping("/update-payment-status/{medicalRecordId}")
    public ResponseEntity<?> updatePaymentStatus(@PathVariable Integer medicalRecordId, @RequestBody String paymentStatus) {
        medicalRecordService.updatePaymentStatus(medicalRecordId, paymentStatus);
        return ResponseUtils.ok("Updated");
    }
}
