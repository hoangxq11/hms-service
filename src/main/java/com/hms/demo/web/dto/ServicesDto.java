package com.hms.demo.web.dto;

import com.hms.demo.model.MedicalDepartment;
import lombok.Data;

@Data
public class ServicesDto {
    private Integer id;
    private String name;
    private Float price;
    private String description;
    private MedicalDepartment department;
}
