package com.hms.demo.service;

import com.hms.demo.web.dto.MedicineDto;
import com.hms.demo.web.dto.request.MedicineCriteria;
import com.hms.demo.web.dto.request.MedicineReq;

import java.util.List;

public interface MedicineService {
    void createMedicine(MedicineReq medicineReq);

    List<MedicineDto> getListMedicine(MedicineCriteria medicineCriteria);

    MedicineDto getMedicine(Integer medicineId);

    void updateMedicine(Integer medicineId, MedicineReq medicineReq);

    void removeMedicine(Integer medicineId);
}
