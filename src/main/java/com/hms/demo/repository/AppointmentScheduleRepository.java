package com.hms.demo.repository;

import com.hms.demo.model.AppointmentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AppointmentScheduleRepository extends JpaRepository<AppointmentSchedule, Integer> {
    List<AppointmentSchedule> findByStaff_Id(Integer staffId);

    List<AppointmentSchedule> findByPatient_Account_Username(String patientUsername);

    Boolean existsByTimeAndTimeFrame(Date time, String timeFrame);

    Boolean existsByPatient_IdAndTime(Integer patientId, Date time);
}
