package com.hms.demo.service.impl;

import com.hms.demo.model.Medicine;
import com.hms.demo.repository.MedicineRepository;
import com.hms.demo.service.MedicineService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.MedicineDto;
import com.hms.demo.web.dto.request.MedicineCriteria;
import com.hms.demo.web.dto.request.MedicineReq;
import com.hms.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository medicineRepository;
    private final MappingHelper mappingHelper;

    @Override
    public void createMedicine(MedicineReq medicineReq) {
        var medicine = mappingHelper.map(medicineReq, Medicine.class);
        medicineRepository.save(medicine);
    }

    @Override
    public List<MedicineDto> getListMedicine(MedicineCriteria medicineCriteria) {
        return medicineRepository.findAll()
                .stream().map(e -> mappingHelper.map(e, MedicineDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDto getMedicine(Integer medicineId) {
        var medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new EntityNotFoundException(Medicine.class.getName()
                        , medicineId.toString()));
        return mappingHelper.map(medicine, MedicineDto.class);
    }

    @Override
    public void updateMedicine(Integer medicineId, MedicineReq medicineReq) {
        var medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new EntityNotFoundException(Medicine.class.getName()
                        , medicineId.toString()));
        mappingHelper.copyProperties(medicineReq, medicine);
        medicineRepository.save(medicine);
    }

    @Override
    public void removeMedicine(Integer medicineId) {
        medicineRepository.deleteById(medicineId);
    }
}
