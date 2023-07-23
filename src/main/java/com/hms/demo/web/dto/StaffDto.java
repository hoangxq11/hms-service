package com.hms.demo.web.dto;

import com.hms.demo.model.Expertise;
import com.hms.demo.model.Position;
import lombok.Data;

import java.util.Date;

@Data
public class StaffDto {
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
    private Expertise expertise;
    private Position position;
    private AccountDto accountDto;
}
