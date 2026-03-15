package com.kristian.gymmanagementsystem.service;

import com.kristian.gymmanagementsystem.model.Trainer;
import com.kristian.gymmanagementsystem.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer updatedTrainer) {
        Trainer existing = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        existing.setName(updatedTrainer.getName());
        existing.setSpecialization(updatedTrainer.getSpecialization());
        existing.setPhone(updatedTrainer.getPhone());
        existing.setActive(updatedTrainer.isActive());
        return trainerRepository.save(existing);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}