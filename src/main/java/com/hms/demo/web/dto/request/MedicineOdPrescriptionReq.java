package com.hms.demo.web.dto.request;

import lombok.Data;

@Data
public class MedicineOdPrescriptionReq {
    private Integer medicineId;
    private Integer quantity;
}
