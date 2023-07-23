package com.hms.demo.repository;

import com.hms.demo.model.MedicalDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalDepartmentRepository extends JpaRepository<MedicalDepartment, Integer> {
}
