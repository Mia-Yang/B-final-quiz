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
    // GTB: - 推荐使用构造器注入
    TraineeService traineeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    // GTB: - @PathVariable应该显式写明value属性
    public List<Trainee> getUngroupedTrainees(@RequestParam Boolean grouped) {
        return traineeService.findUngroupedTrainee(grouped);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // GTB: - 添加@Valid校验才能生效
    public void createTrainee(@RequestBody Trainee trainee) {
        traineeService.createTrainee(trainee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // GTB: - @RequestParam应该显式写明value属性
    public void deleteTrainee(@PathVariable long id) {
        traineeService.deleteTrainee(id);
    }
}
