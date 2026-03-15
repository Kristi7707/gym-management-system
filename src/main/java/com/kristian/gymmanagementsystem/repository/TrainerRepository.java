package com.kristian.gymmanagementsystem.repository;

import com.kristian.gymmanagementsystem.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}