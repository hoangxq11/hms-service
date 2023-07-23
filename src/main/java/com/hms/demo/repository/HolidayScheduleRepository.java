package com.hms.demo.repository;

import com.hms.demo.model.HolidaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayScheduleRepository extends JpaRepository<HolidaySchedule, Integer> {
}
