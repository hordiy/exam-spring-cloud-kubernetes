package com.hordiienko.history.controllers;

import com.hordiienko.history.models.Exercise;
import com.hordiienko.history.services.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService service;


    @GetMapping("/random")
    public List<Exercise> getExercises(@RequestParam(value = "amount",defaultValue = "1") int amount) {
        return service.getRandomExercise(amount);
    }

}
