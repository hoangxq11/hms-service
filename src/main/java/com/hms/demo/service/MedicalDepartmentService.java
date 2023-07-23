package com.hms.demo.service;

import com.hms.demo.model.MedicalDepartment;
import com.hms.demo.web.dto.request.MedicalDepartmentReq;

import java.util.List;

public interface MedicalDepartmentService {
    void createMedicalDepartment(MedicalDepartmentReq medicalDepartmentReq);

    List<MedicalDepartment> getListMedicalDepartment();

    MedicalDepartment getMedicalDepartment(Integer medicalDepartmentId);

    void updateMedicalDepartment(Integer medicalDepartmentId, MedicalDepartmentReq medicalDepartmentReq);

    void removeMedicalDepartment(Integer medicalDepartmentId);
}
