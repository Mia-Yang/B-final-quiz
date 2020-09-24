package com.example.demo.Api;

import com.example.demo.domain.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    TrainerService trainerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Trainer> getUngroupedTrainees(@RequestParam boolean grouped) {
        return trainerService.findUngroupedTrainer(grouped);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrainee(@RequestBody Trainer trainer) {
        trainerService.createTrainer(trainer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable Long id) {
        trainerService.deleteTrainerById(id);
    }
}
