package com.hms.demo.web.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class PatientReq {
    private String fullName;
    private String ethnic;
    private Date dateOfBirth;
    private String job;
    private String gender;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private String description;
}
