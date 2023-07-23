package com.hms.demo.web.dto.request;

import lombok.Data;

@Data
public class ServicesReq {
    private String name;
    private Float price;
    private String description;
    private Integer departmentId;
}
