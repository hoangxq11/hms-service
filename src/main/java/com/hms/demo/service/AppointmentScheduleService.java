package com.hms.demo.service;

import com.hms.demo.web.dto.AppointmentScheduleDto;
import com.hms.demo.web.dto.request.AppointmentScheduleReq;

import java.util.List;

public interface AppointmentScheduleService {
    void createAppointmentSchedule(AppointmentScheduleReq appointmentScheduleReq);

    List<AppointmentScheduleDto> getSchedules();

    List<AppointmentScheduleDto> getScheduleOfDoctor(Integer doctorId);

    List<AppointmentScheduleDto> getScheduleOfPatient(String patientUsername);

    AppointmentScheduleDto getScheduleById(Integer scheduleId);

    void updateSchedule(Integer scheduleId, AppointmentScheduleReq appointmentScheduleReq);

    void deleteSchedule(Integer scheduleId);
}
