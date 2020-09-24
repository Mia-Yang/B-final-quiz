package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
        Trainer trainer = Trainer.builder().id(1L).grouped(false).name("桂溪京").build();
        trainerRepository.save(trainer);
    }

    public List<Trainer> findUngroupedTrainer() {
        List<Trainer> trainers = trainerRepository.findAll();
        if(trainers.isEmpty()) {
            return Collections.emptyList();
        }
        return trainers.stream().filter(trainer -> !trainer.isGrouped()).collect(Collectors.toList());
    }

    public void createTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public void deleteTrainerById(long id) {
        trainerRepository.deleteById(id);
    }
}
