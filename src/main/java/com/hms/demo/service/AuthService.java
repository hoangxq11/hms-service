package com.hms.demo.service;

import com.hms.demo.model.Account;
import com.hms.demo.web.dto.AccountDto;
import com.hms.demo.web.dto.request.*;
import com.hms.demo.web.dto.response.JwtResponse;

public interface AuthService {
    JwtResponse authenticateAccount(LoginRequest loginRequest);

    Account createAccount(SignupRequest signupRequest);

    void registerPatient(RegisterPatientReq registerPatientReq);

    void registerStaff(RegisterStaffReq registerStaffReq);

    void updateAccount(Integer accountId, AccountReq accountReq);

    AccountDto getAccount(Integer accountId);
}
