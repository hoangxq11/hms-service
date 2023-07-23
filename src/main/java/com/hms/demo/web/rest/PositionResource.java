package com.hms.demo.web.rest;

import com.hms.demo.service.PositionService;
import com.hms.demo.web.dto.request.PositionReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/position")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PositionResource {

    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<?> getAllPosition() {
        return ResponseUtils.ok(positionService.getAllPosition());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPositionById(@PathVariable Integer id) {
        return ResponseUtils.ok(positionService.getPositionById(id));
    }

    @PostMapping
    public ResponseEntity<?> createPosition(@RequestBody PositionReq positionReq) {
        positionService.createPosition(positionReq);
        return ResponseUtils.created();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePosition(@PathVariable Integer id, @RequestBody PositionReq positionReq) {
        positionService.updatePosition(id, positionReq);
        return ResponseUtils.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePosition(@PathVariable Integer id) {
        positionService.removePosition(id);
        return ResponseUtils.ok("Removed");
    }
}
