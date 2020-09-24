package com.example.demo.service;
import com.example.demo.domain.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraineeService {
    private TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
        Trainee trainee = Trainee.builder().name("杨思雨").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee);
    }

    public List<Trainee> findUngroupedTrainee() {
        List<Trainee> trainees = traineeRepository.findAll();
        if(trainees.isEmpty()) {
            return Collections.emptyList();
        }
        return trainees.stream().filter(trainee -> !trainee.isGrouped()).collect(Collectors.toList());
    }

    public void createTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
    }

    public void deleteTrainee(Long id) {
        traineeRepository.deleteById(id);
    }
}

