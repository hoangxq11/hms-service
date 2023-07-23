package com.hms.demo.repository;

import com.hms.demo.model.MedicalRecordInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalRecordInfoRepository extends JpaRepository<MedicalRecordInformation, Integer> {
    Optional<MedicalRecordInformation> findByMedicalRecord_Id(Integer medicalRecordId);
}
