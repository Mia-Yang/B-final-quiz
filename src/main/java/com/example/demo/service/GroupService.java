package com.example.demo.service;

import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

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
}
