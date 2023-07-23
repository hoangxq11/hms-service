package com.hms.demo.repository;

import com.hms.demo.model.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalTestRepository extends JpaRepository<MedicalTest, Integer> {
    Optional<MedicalTest> findByMedicalRecord_Id(Integer medicalRecordId);
}
