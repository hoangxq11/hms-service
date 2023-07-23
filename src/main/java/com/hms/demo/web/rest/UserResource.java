package com.hms.demo.web.rest;

import com.hms.demo.service.UserService;
import com.hms.demo.web.dto.request.PatientCriteria;
import com.hms.demo.web.dto.request.PatientReq;
import com.hms.demo.web.dto.request.StaffCriteria;
import com.hms.demo.web.dto.request.StaffReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/get-accounts")
    public ResponseEntity<?> getAllAccounts() {
        return ResponseUtils.ok(userService.getAllAccounts());
    }

    @PostMapping("/get-patients")
    public ResponseEntity<?> getCustomPatients(@RequestBody PatientCriteria patientCriteria) {
        return ResponseUtils.ok(userService.getCustomPatients(patientCriteria));
    }

    @PostMapping("/get-staffs")
    public ResponseEntity<?> getCustomStaff(@RequestBody StaffCriteria staffCriteria) {
        return ResponseUtils.ok(userService.getCustomStaff(staffCriteria));
    }

    @GetMapping("/get-patient/{patientId}")
    public ResponseEntity<?> getPatient(@PathVariable Integer patientId) {
        return ResponseUtils.ok(userService.getPatient(patientId));
    }

    @GetMapping("/get-staff/{staffId}")
    public ResponseEntity<?> getStaff(@PathVariable Integer staffId) {
        return ResponseUtils.ok(userService.getStaff(staffId));
    }

    @GetMapping("/get-patient-by-username/{username}")
    public ResponseEntity<?> getPatientByUsername(@PathVariable String username) {
        return ResponseUtils.ok(userService.getPatientByUsername(username));
    }

    @GetMapping("/get-staff-by-username/{username}")
    public ResponseEntity<?> getStaffByUsername(@PathVariable String username) {
        return ResponseUtils.ok(userService.getStaffByUsername(username));
    }

    @PutMapping("/update-patient/{patientId}")
    public ResponseEntity<?> updatePatient(@PathVariable Integer patientId, @RequestBody PatientReq patientReq) {
        userService.updatePatient(patientId, patientReq);
        return ResponseUtils.ok("Updated");
    }

    @PutMapping("/update-staff/{staffId}")
    public ResponseEntity<?> UpdateStaff(@PathVariable Integer staffId, @RequestBody StaffReq staffReq) {
        userService.updateStaff(staffId, staffReq);
        return ResponseUtils.ok("Updated");
    }

}
