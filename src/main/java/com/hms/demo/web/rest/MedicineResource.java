package com.hms.demo.web.rest;

import com.hms.demo.service.MedicineService;
import com.hms.demo.web.dto.request.MedicineCriteria;
import com.hms.demo.web.dto.request.MedicineReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MedicineResource {
    private final MedicineService medicineService;

    @PostMapping("/create-medicine")
    public ResponseEntity<?> createMedicine(@RequestBody MedicineReq medicineReq) {
        medicineService.createMedicine(medicineReq);
        return ResponseUtils.created();
    }

    @PostMapping
    public ResponseEntity<?> getListMedicine(@RequestBody MedicineCriteria medicineCriteria) {
        return ResponseUtils.ok(medicineService.getListMedicine(medicineCriteria));
    }

    @GetMapping("/{medicineId}")
    public ResponseEntity<?> getMedicine(@PathVariable Integer medicineId) {
        return ResponseUtils.ok(medicineService.getMedicine(medicineId));
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<?> updateMedicine(@PathVariable Integer medicineId, @RequestBody MedicineReq medicineReq) {
        medicineService.updateMedicine(medicineId, medicineReq);
        return ResponseUtils.ok("Updated");
    }

    @DeleteMapping("/{medicineId}")
    public ResponseEntity<?> removeMedicine(@PathVariable Integer medicineId) {
        medicineService.removeMedicine(medicineId);
        return ResponseUtils.ok("Removed");
    }
}
