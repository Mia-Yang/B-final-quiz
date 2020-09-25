package com.example.demo.service;
import com.example.demo.domain.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TraineeService {
    private TraineeRepository traineeRepository;

    // GTB: - 不应该在应用代码中初始化数据库
    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
        Trainee trainee1 = Trainee.builder().name("杨思雨").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee1);
        Trainee trainee2 = Trainee.builder().name("沈乐祺").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee2);
        Trainee trainee3 = Trainee.builder().name("王江林").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee3);
        Trainee trainee4 = Trainee.builder().name("王登宇").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee4);
        Trainee trainee5 = Trainee.builder().name("陈思聪").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee5);
        Trainee trainee6 = Trainee.builder().name("徐慧慧").email("yang@163.com").github("Mia-Yang")
                .office("西安").zoomId("1234").grouped(false).build();
        traineeRepository.save(trainee6);


    }

    public List<Trainee> findUngroupedTrainee(Boolean grouped) {
        List<Trainee> trainees = traineeRepository.findByGrouped(grouped);
        return trainees.isEmpty()?Collections.emptyList():trainees;
    }

    public void createTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
    }

    public void deleteTrainee(Long id) {
        // GTB: - 删除学员或讲师，Id不存在时应该抛出异常
        traineeRepository.deleteById(id);
    }
}

