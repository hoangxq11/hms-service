package com.hms.demo.web.rest;

import com.hms.demo.service.MedicalDepartmentService;
import com.hms.demo.web.dto.request.MedicalDepartmentReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-department")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MedicalDepartmentResource {
    private final MedicalDepartmentService medicalDepartmentService;

    @PostMapping
    public ResponseEntity<?> createMedicalDepartment(@RequestBody MedicalDepartmentReq medicalDepartmentReq) {
        medicalDepartmentService.createMedicalDepartment(medicalDepartmentReq);
        return ResponseUtils.created();
    }

    @GetMapping
    public ResponseEntity<?> getListMedicalDepartment() {
        return ResponseUtils.ok(medicalDepartmentService.getListMedicalDepartment());
    }

    @GetMapping("/{medicalDepartmentId}")
    public ResponseEntity<?> getMedicalDepartment(@PathVariable Integer medicalDepartmentId) {
        return ResponseUtils.ok(medicalDepartmentService.getMedicalDepartment(medicalDepartmentId));
    }

    @PutMapping("/{medicalDepartmentId}")
    public ResponseEntity<?> updateMedicalDepartment(@PathVariable Integer medicalDepartmentId, @RequestBody MedicalDepartmentReq medicalDepartmentReq) {
        medicalDepartmentService.updateMedicalDepartment(medicalDepartmentId, medicalDepartmentReq);
        return ResponseUtils.ok("Updated");
    }

    @DeleteMapping("/{medicalDepartmentId}")
    public ResponseEntity<?> removeMedicalDepartment(@PathVariable Integer medicalDepartmentId) {
        medicalDepartmentService.removeMedicalDepartment(medicalDepartmentId);
        return ResponseUtils.ok("Removed");
    }
}
