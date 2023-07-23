package com.hms.demo.web.rest;

import com.hms.demo.service.PrescriptionService;
import com.hms.demo.web.dto.request.PrescriptionReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescription")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PrescriptionResource {
    private final PrescriptionService prescriptionService;

    @PostMapping("/create")
    public ResponseEntity<?> createPrescription(@RequestBody PrescriptionReq prescriptionReq) {
        prescriptionService.createPrescription(prescriptionReq);
        return ResponseUtils.created();
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<?> getPrescriptionById(@PathVariable Integer prescriptionId) {
        return ResponseUtils.ok(prescriptionService.getPrescriptionById(prescriptionId));
    }

    @GetMapping("/prescription-of-medical-record/{medicalRecordId}")
    public ResponseEntity<?> getPrescriptionOfMedicalRecord(@PathVariable Integer medicalRecordId) {
        return ResponseUtils.ok(prescriptionService.getPrescriptionOfMedicalRecord(medicalRecordId));
    }
}
