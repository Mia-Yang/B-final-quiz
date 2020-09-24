package com.example.demo.Api;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    TraineeService traineeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Trainee> getUngroupedTrainees(@RequestParam Boolean grouped) {
        return traineeService.findUngroupedTrainee(grouped);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrainee(@RequestBody Trainee trainee) {
        traineeService.createTrainee(trainee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable long id) {
        traineeService.deleteTrainee(id);
    }
}
