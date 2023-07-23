package com.hms.demo.web.rest;

import com.hms.demo.service.AuthService;
import com.hms.demo.web.dto.request.*;
import com.hms.demo.web.dto.response.utils.Response;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthResource {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Response> authenticateAccount(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseUtils.ok(authService.authenticateAccount(loginRequest));
    }

    @PostMapping("/create-account")
    public ResponseEntity<Response> createAccount(@Valid @RequestBody SignupRequest signupRequest) {
        authService.createAccount(signupRequest);
        return ResponseUtils.created();
    }

    @PutMapping("/update-account/{accountId}")
    public ResponseEntity<Response> updateAccount(@Valid @RequestBody AccountReq accountReq, @PathVariable Integer accountId) {
        authService.updateAccount(accountId, accountReq);
        return ResponseUtils.ok("Updated");
    }

    @PostMapping("/register-patient")
    public ResponseEntity<Response> registerPatient(@Valid @RequestBody RegisterPatientReq registerPatientReq) {
        authService.registerPatient(registerPatientReq);
        return ResponseUtils.created();
    }

    @PostMapping("/register-staff")
    public ResponseEntity<Response> registerStaff(@Valid @RequestBody RegisterStaffReq registerStaffReq) {
        authService.registerStaff(registerStaffReq);
        return ResponseUtils.created();
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Response> getAccount(@PathVariable Integer accountId) {
        return ResponseUtils.ok(authService.getAccount(accountId));
    }

}
