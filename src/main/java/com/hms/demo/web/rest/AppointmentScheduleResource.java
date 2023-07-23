package com.hms.demo.web.rest;

import com.hms.demo.service.AppointmentScheduleService;
import com.hms.demo.web.dto.request.AppointmentScheduleReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment-schedule")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AppointmentScheduleResource {
    private final AppointmentScheduleService appointmentScheduleService;

    @PostMapping("/create")
    public ResponseEntity<?> createAppointmentSchedule(@RequestBody AppointmentScheduleReq appointmentScheduleReq) {
        appointmentScheduleService.createAppointmentSchedule(appointmentScheduleReq);
        return ResponseUtils.created();
    }

    @GetMapping
    public ResponseEntity<?> getSchedules() {
        return ResponseUtils.ok(appointmentScheduleService.getSchedules());
    }

    @GetMapping("/get-schedule-of-doctor/{doctorId}")
    public ResponseEntity<?> getScheduleOfDoctor(@PathVariable Integer doctorId) {
        return ResponseUtils.ok(appointmentScheduleService.getScheduleOfDoctor(doctorId));
    }

    @GetMapping("/get-schedule-of-patient/{patientUsername}")
    public ResponseEntity<?> getScheduleOfPatient(@PathVariable String patientUsername) {
        return ResponseUtils.ok(appointmentScheduleService.getScheduleOfPatient(patientUsername));
    }

    @GetMapping("/get-schedule/{scheduleId}")
    public ResponseEntity<?> getScheduleById(@PathVariable Integer scheduleId) {
        return ResponseUtils.ok(appointmentScheduleService.getScheduleById(scheduleId));
    }

    @PutMapping("/update-schedule/{scheduleId}")
    public ResponseEntity<?> updateSchedule(@PathVariable Integer scheduleId
            , @RequestBody AppointmentScheduleReq appointmentScheduleReq) {
        appointmentScheduleService.updateSchedule(scheduleId, appointmentScheduleReq);
        return ResponseUtils.ok("Updated");
    }

    @DeleteMapping("/delete-schedule/{scheduleId}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Integer scheduleId) {
        appointmentScheduleService.deleteSchedule(scheduleId);
        return ResponseUtils.ok("Updated");
    }
}
