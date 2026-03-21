package com.kristian.gymmanagementsystem.service;

import com.kristian.gymmanagementsystem.exception.ResourceNotFoundException;
import com.kristian.gymmanagementsystem.model.Attendance;
import com.kristian.gymmanagementsystem.model.Member;
import com.kristian.gymmanagementsystem.repository.AttendanceRepository;
import com.kristian.gymmanagementsystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final MemberRepository memberRepository;

    public Attendance checkIn(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Attendance attendance = new Attendance();
        attendance.setMember(member);
        attendance.setCheckInTime(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }

    public Attendance checkOut(Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() ->  new ResourceNotFoundException("Attendance record with id " + attendanceId + " not found"));
        attendance.setCheckOutTime(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getMemberAttendance(Long memberId) {
        return attendanceRepository.findByMemberId(memberId);
    }
}