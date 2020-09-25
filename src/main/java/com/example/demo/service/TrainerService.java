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
        Trainer trainer1 = Trainer.builder().grouped(false).name("桂溪京").build();
        trainerRepository.save(trainer1);
        Trainer trainer2 = Trainer.builder().grouped(false).name("张钊").build();
        trainerRepository.save(trainer2);
        Trainer trainer3 = Trainer.builder().grouped(false).name("杜娟").build();
        trainerRepository.save(trainer3);
    }

    public List<Trainer> findUngroupedTrainer(boolean grouped) {
        List<Trainer> trainers = trainerRepository.findByGrouped(grouped);
        // GTB: - 不必要的三元表达式
        return trainers.isEmpty()?Collections.emptyList():trainers;
    }

    public void createTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public void deleteTrainerById(long id) {
        // GTB: - 删除学员或讲师，Id不存在时应该抛出异常
        trainerRepository.deleteById(id);
    }
}
