package com.kristian.gymmanagementsystem.repository;

import com.kristian.gymmanagementsystem.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByMemberId(Long memberId);
    void deleteByMemberId(Long memberId);
}