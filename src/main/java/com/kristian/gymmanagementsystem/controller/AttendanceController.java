package com.kristian.gymmanagementsystem.controller;

import com.kristian.gymmanagementsystem.model.Attendance;
import com.kristian.gymmanagementsystem.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/checkin/{memberId}")
    public Attendance checkIn(@PathVariable Long memberId) {
        return attendanceService.checkIn(memberId);
    }

    @PutMapping("/checkout/{attendanceId}")
    public Attendance checkOut(@PathVariable Long attendanceId) {
        return attendanceService.checkOut(attendanceId);
    }

    @GetMapping("/member/{memberId}")
    public List<Attendance> getMemberAttendance(@PathVariable Long memberId) {
        return attendanceService.getMemberAttendance(memberId);
    }
}