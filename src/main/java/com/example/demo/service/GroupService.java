package com.example.demo.service;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private TrainerRepository trainerRepository;
    private TraineeRepository traineeRepository;

    public GroupService(GroupRepository groupRepository, TrainerRepository trainerRepository, TraineeRepository traineeRepository) {
        this.groupRepository = groupRepository;
        this.traineeRepository = traineeRepository;
        this.trainerRepository = trainerRepository;
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public void renameGroup(Long id, String name) {
        groupRepository.findById(id).get().setName(name);
    }


    public List<Group> autoGrouping() {
        List<Trainer> trainers = trainerRepository.findAll();
        List<Trainee> trainees = traineeRepository.findAll();
        if (trainers.size() < 2 || trainers.size() < 1 || trainees.size() < trainers.size() / 2) {
            throw new RuntimeException();
        }
        int groupCount = trainers.size() % 2 == 0 ? trainers.size() % 2 : (trainers.size() - 1) % 2;
        List<Group> groups = this.emptyGroup(trainers,groupCount);
        groups = this.groupTrainers(trainers, groups, groupCount);
        groups = this.groupTrainees(trainees, groups, groupCount);
        return groups;
    }

    public List<Group> emptyGroup(List<Trainer> trainers, int groupCount){
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < groupCount; i++) {
            groups.add(Group.builder().id((long) (i + 1)).name((i + 1) + "组").build());
        }
        return groups;
    }

    public List<Group> groupTrainers(List<Trainer> trainers, List<Group> groups, int groupCount) {
        Collections.shuffle(trainers);
        for (int i = 0; i < groupCount; i++) {
            List<Trainer> prepTrainer = trainers.subList(i*2, i*2+1);
            groups.get(i).setTrainers(prepTrainer);
        }
        return groups;
    }

    public List<Group> groupTrainees(List<Trainee> trainees, List<Group> groups, int groupCount) {
        Collections.shuffle(trainees);
        int traineeCount = trainees.size()/groupCount;
        for(int i = 0; i < groupCount; i++) {
            List<Trainee> prepTrainee = trainees.subList(i*traineeCount, i*traineeCount+(traineeCount-1));
            groups.get(i).setTrainees(prepTrainee);
        }
        return groups;
    }
}
