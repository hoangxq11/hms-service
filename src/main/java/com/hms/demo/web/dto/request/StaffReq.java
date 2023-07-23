package com.hms.demo.web.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class StaffReq {
    private String fullName;
    private String ethnic;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private String description;
    private Integer expertiseId;
    private Integer positionId;
}
