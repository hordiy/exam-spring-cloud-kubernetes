package com.hordiienko.mathematic.services;

import com.hordiienko.mathematic.models.Exercise;

public interface MathematicService {

    Exercise getRandomExercise();

    /**
     * Get max available value in the exercise.
     * @return
     */
    int getMaxAvailableNumber();
}
