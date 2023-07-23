package com.hms.demo.service.impl;

import com.hms.demo.model.Expertise;
import com.hms.demo.model.Patient;
import com.hms.demo.model.Staff;
import com.hms.demo.repository.*;
import com.hms.demo.service.UserService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.AccountDto;
import com.hms.demo.web.dto.PatientDto;
import com.hms.demo.web.dto.StaffDto;
import com.hms.demo.web.dto.request.PatientCriteria;
import com.hms.demo.web.dto.request.PatientReq;
import com.hms.demo.web.dto.request.StaffCriteria;
import com.hms.demo.web.dto.request.StaffReq;
import com.hms.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AccountRepository accountRepository;
    private final PatientRepository patientRepository;
    private final StaffRepository staffRepository;
    private final ExpertiseRepository expertiseRepository;
    private final PositionRepository positionRepository;
    private final MappingHelper mappingHelper;


    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(e -> {
                    var res = mappingHelper.map(e, AccountDto.class);
                    res.setAuthority(e.getAuthority().getName());
                    return res;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDto> getCustomPatients(PatientCriteria patientCriteria) {
        return patientRepository.findAll()
                .stream().map(e -> {
                    var res = mappingHelper.map(e, PatientDto.class);
                    res.setAccountDto(mappingHelper.map(e.getAccount(), AccountDto.class));
                    return res;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffDto> getCustomStaff(StaffCriteria staffCriteria) {
        return staffRepository.findAll()
                .stream().map(e -> {
                    var res = mappingHelper.map(e, StaffDto.class);
                    var accountDto = mappingHelper.map(e.getAccount(), AccountDto.class);
                    accountDto.setAuthority(e.getAccount().getAuthority().getName());
                    res.setAccountDto(accountDto);
                    return res;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatient(Integer patientId) {
        var patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException(Patient.class.getName(), patientId.toString()));
        return mappingHelper.map(patient, PatientDto.class);
    }

    @Override
    public StaffDto getStaff(Integer staffId) {
        var staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new EntityNotFoundException(Staff.class.getName(), staffId.toString()));
        var res = mappingHelper.map(staff, StaffDto.class);
        var accountDto = mappingHelper.map(staff.getAccount(), AccountDto.class);
        accountDto.setAuthority(staff.getAccount().getAuthority().getName());
        res.setAccountDto(accountDto);
        return res;
    }

    @Override
    public void updatePatient(Integer patientId, PatientReq patientReq) {
        var patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException(Patient.class.getName(), patientId.toString()));
        mappingHelper.copyProperties(patientReq, patient);
        patientRepository.save(patient);
    }

    @Override
    public void updateStaff(Integer staffId, StaffReq staffReq) {
        var staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new EntityNotFoundException(Staff.class.getName(), staffId.toString()));
        mappingHelper.copyProperties(staffReq, staff);
        staff.setExpertise(expertiseRepository.findById(staffReq.getExpertiseId())
                .orElseThrow(() -> new EntityNotFoundException(Expertise.class.getName()
                        , staffReq.getExpertiseId().toString())));
        staff.setPosition(positionRepository.findById(staffReq.getPositionId())
                .orElseThrow(() -> new EntityNotFoundException(Expertise.class.getName()
                        , staffReq.getPositionId().toString())));
        staffRepository.save(staff);
    }

    @Override
    public PatientDto getPatientByUsername(String username) {
        var patient = patientRepository.findByAccount_Username(username)
                .orElseThrow(() -> new EntityNotFoundException(Patient.class.getName(), username));
        return mappingHelper.map(patient, PatientDto.class);
    }

    @Override
    public StaffDto getStaffByUsername(String username) {
        var staff = staffRepository.findByAccount_Username(username)
                .orElseThrow(() -> new EntityNotFoundException(Staff.class.getName(), username));
        var res = mappingHelper.map(staff, StaffDto.class);
        var accountDto = mappingHelper.map(staff.getAccount(), AccountDto.class);
        accountDto.setAuthority(staff.getAccount().getAuthority().getName());
        res.setAccountDto(accountDto);
        return res;
    }
}