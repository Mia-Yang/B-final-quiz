package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
        Trainer trainer = Trainer.builder().id(1L).grouped(false).name("桂溪京").build();
        trainerRepository.save(trainer);
    }

    public List<Trainer> findUngroupedTrainer(boolean grouped) {
        List<Trainer> trainers = trainerRepository.findByGrouped(grouped);
        return trainers.isEmpty()?Collections.emptyList():trainers;
    }

    public void createTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public void deleteTrainerById(long id) {
        trainerRepository.deleteById(id);
    }
}
