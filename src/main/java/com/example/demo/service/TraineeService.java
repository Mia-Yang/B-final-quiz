package com.example.demo.service;
import com.example.demo.domain.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TraineeService {
    private TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
        Trainee trainee = Trainee.builder().name("杨思雨").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee);
    }

    public List<Trainee> findUngroupedTrainee(Boolean grouped) {
        List<Trainee> trainees = traineeRepository.findByGrouped(grouped);
        return trainees.isEmpty()?Collections.emptyList():trainees;
    }

    public void createTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
    }

    public void deleteTrainee(Long id) {
        traineeRepository.deleteById(id);
    }
}

