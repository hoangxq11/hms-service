package com.hms.demo.web.dto.request;

import lombok.Data;

@Data
public class RegisterPatientReq {
    private SignupRequest signupRequest;
    private PatientReq patientReq;
}
