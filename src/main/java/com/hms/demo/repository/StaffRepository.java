package com.hms.demo.repository;

import com.hms.demo.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff> {
    Optional<Staff> findByAccount_Id(Integer accountId);
    Optional<Staff> findByAccount_Username(String username);
}
