package com.hms.demo.web.dto;

import lombok.Data;

@Data
public class MedicineDto {
    private Integer id;
    private String name;
    private String useManual;
    private String unit;
    private Integer quantity;
    private Float price;
    private String activeElement;
    private String content;
    private String using;
    private String packing;
    private String productionUnit;
    private String declaringUnit;
}
