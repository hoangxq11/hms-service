package com.hms.demo.web.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDto {
    private Integer id;
    private String fullName;
    private String ethnic;
    private Date dateOfBirth;
    private String job;
    private String gender;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private String description;
    private AccountDto accountDto;
}
