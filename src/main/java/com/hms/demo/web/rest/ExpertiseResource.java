package com.hms.demo.web.rest;

import com.hms.demo.service.ExpertiseService;
import com.hms.demo.web.dto.request.ExpertiseReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expertise")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ExpertiseResource {
    private final ExpertiseService expertiseService;

    @GetMapping
    public ResponseEntity<?> getAllExpertise() {
        return ResponseUtils.ok(expertiseService.getAllExpertise());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExpertiseById(@PathVariable Integer id) {
        return ResponseUtils.ok(expertiseService.getExpertiseById(id));
    }

    @PostMapping
    public ResponseEntity<?> createExpertise(@RequestBody ExpertiseReq expertiseReq) {
        expertiseService.createExpertise(expertiseReq);
        return ResponseUtils.created();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpertise(@PathVariable Integer id, @RequestBody ExpertiseReq expertiseReq) {
        expertiseService.updateExpertise(id, expertiseReq);
        return ResponseUtils.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeExpertise(@PathVariable Integer id) {
        expertiseService.removeExpertise(id);
        return ResponseUtils.ok("Removed");
    }
}
