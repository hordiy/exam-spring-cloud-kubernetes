package com.hordiienko.mathematic.services;

import com.hordiienko.mathematic.models.Exercise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MathematicServiceImpl implements MathematicService{

    @Value("${math.max}")
    private int max;

    private final Random random = new Random();

    @Override
    public Exercise getRandomExercise() {
        int a = random.nextInt(max);
        int b = random.nextInt(max);
        return Exercise.builder().question(a + " + " + b + " = ?").answer(String.valueOf(a + b)).build();
    }

    @Override
    public int getMaxAvailableNumber() {
        return max;
    }
}
