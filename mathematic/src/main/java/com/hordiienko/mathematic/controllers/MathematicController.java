package com.hordiienko.mathematic.controllers;

import com.hordiienko.mathematic.models.Exercise;
import com.hordiienko.mathematic.services.MathematicService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/exercise")
@AllArgsConstructor
public class MathematicController {

    private MathematicService mathematicService;

    @GetMapping("/random")
    public List<Exercise> getExercises(@RequestParam(value = "amount", defaultValue = "1") int amount) {
        return Stream.generate(mathematicService::getRandomExercise).limit(amount).collect(Collectors.toList());
    }
}
