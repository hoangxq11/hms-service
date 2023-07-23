package com.hms.demo.repository;

import com.hms.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer>, JpaSpecificationExecutor<Patient> {
    Optional<Patient> findByAccount_Id(Integer accountId);
    Optional<Patient> findByAccount_Username(String username);
}
