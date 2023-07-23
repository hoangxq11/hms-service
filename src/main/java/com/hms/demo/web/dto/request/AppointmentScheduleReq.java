package com.hms.demo.web.dto.request;

import lombok.Data;

import java.sql.Date;

@Data
public class AppointmentScheduleReq {
    private Integer staffId;
    private Integer patientId;
    private Date time;
    private String status;
    private String timeFrame;
}
