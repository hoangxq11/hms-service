package com.hms.demo.repository;

import com.hms.demo.model.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertiseRepository extends JpaRepository<Expertise, Integer> {
}
