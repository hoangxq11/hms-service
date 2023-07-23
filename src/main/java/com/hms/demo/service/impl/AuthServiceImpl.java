package com.hms.demo.service.impl;

import com.hms.demo.model.*;
import com.hms.demo.repository.*;
import com.hms.demo.service.AuthService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.AccountDto;
import com.hms.demo.web.dto.request.*;
import com.hms.demo.web.dto.response.JwtResponse;
import com.hms.demo.web.exception.EntityNotFoundException;
import com.hms.demo.web.exception.ServiceException;
import com.hms.demo.web.security.AuthoritiesConstants;
import com.hms.demo.web.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AccountRepository accountRepository;
    private final AuthorityRepository authorityRepository;
    private final PatientRepository patientRepository;
    private final StaffRepository staffRepository;
    private final ExpertiseRepository expertiseRepository;
    private final PositionRepository positionRepository;
    private final MappingHelper mappingHelper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse authenticateAccount(LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(), loginRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtUtils.generateJwtToken(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<String> authorities = userDetails.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return new JwtResponse(jwtToken, "Bearer", userDetails.getUsername(), authorities.get(0));

        } catch (AuthenticationException authenticationException) {
            throw new ServiceException("Username or password is invalid", "err.authorize.unauthorized");
        }

    }

    @Override
    public Account createAccount(SignupRequest signupRequest) {
        if (accountRepository.existsByUsernameOrEmail(signupRequest.getUsername(), signupRequest.getEmail()))
            throw new ServiceException("Email or username is existed in system", "err.api.email-username-is-existed");

        Account account = new Account();
        account.setUsername(signupRequest.getUsername());
        account.setEmail(signupRequest.getEmail());
        account.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        String authority = signupRequest.getAuthority();

        if (authority == null || authority.isEmpty() || authority.isBlank()) {
            account.setAuthority(authorityRepository.findByName(AuthoritiesConstants.PATIENT).orElseThrow(
                    () -> new EntityNotFoundException(Authority.class.getName(), AuthoritiesConstants.PATIENT)
            ));
        } else {
            account.setAuthority(authorityRepository.findByName(authority).orElseThrow(
                    () -> new EntityNotFoundException(Authority.class.getName(), authority)
            ));
        }
        return accountRepository.save(account);
    }

    @Override
    public void registerPatient(RegisterPatientReq registerPatientReq) {
        Account account = createAccount(registerPatientReq.getSignupRequest());
        var patient = mappingHelper.map(registerPatientReq.getPatientReq(), Patient.class);
        patient.setAccount(account);
        patientRepository.save(patient);
    }

    @Override
    public void registerStaff(RegisterStaffReq registerStaffReq) {
        var staff = mappingHelper.map(registerStaffReq.getStaffReq(), Staff.class);
        Account account = createAccount(registerStaffReq.getSignupRequest());
        staff.setAccount(account);
        staff.setExpertise(expertiseRepository.findById(registerStaffReq.getStaffReq().getExpertiseId())
                .orElseThrow(() -> new EntityNotFoundException(Expertise.class.getName()
                        , registerStaffReq.getStaffReq().getExpertiseId().toString())));
        staff.setPosition(positionRepository.findById(registerStaffReq.getStaffReq().getPositionId())
                .orElseThrow(() -> new EntityNotFoundException(Expertise.class.getName()
                        , registerStaffReq.getStaffReq().getPositionId().toString())));
        staffRepository.save(staff);
    }

    @Override
    public void updateAccount(Integer accountId, AccountReq accountReq) {
        var account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException(Account.class.getName()
                        , accountId.toString()));

        if (accountRepository.existsByUsernameOrEmail(accountReq.getUsername(), accountReq.getEmail())
                && !accountReq.getUsername().equals(account.getUsername()) && !accountReq.getUsername().equals(account.getUsername()))
            throw new ServiceException("Email or username is existed in system", "err.api.email-username-is-existed");

        mappingHelper.mapIfSourceNotNullAndStringNotBlank(accountReq, account);
        String authority = accountReq.getAuthority();

        if (authority == null || authority.isEmpty() || authority.isBlank()) {
            account.setAuthority(authorityRepository.findByName(AuthoritiesConstants.PATIENT).orElseThrow(
                    () -> new EntityNotFoundException(Authority.class.getName(), AuthoritiesConstants.PATIENT)
            ));
        } else {
            account.setAuthority(authorityRepository.findByName(authority).orElseThrow(
                    () -> new EntityNotFoundException(Authority.class.getName(), authority)
            ));
        }

        accountRepository.save(account);
    }

    @Override
    public AccountDto getAccount(Integer accountId) {
        var account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException(Account.class.getName()
                        , accountId.toString()));
        var res = mappingHelper.map(account, AccountDto.class);
        res.setAuthority(account.getAuthority().getName());
        return res;
    }
}
