package com.hms.demo.web.dto.request;

import lombok.Data;

@Data
public class RegisterStaffReq {
    private SignupRequest signupRequest;
    private StaffReq staffReq;
}
