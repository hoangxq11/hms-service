package com.hms.demo.web.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AppointmentScheduleDto {
    private Integer id;
    private StaffDto staffDto;
    private PatientDto patientDto;
    private Date time;
    private String status;
    private String timeFrame;
}
