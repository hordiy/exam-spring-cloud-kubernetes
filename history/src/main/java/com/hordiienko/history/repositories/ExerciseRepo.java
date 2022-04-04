package com.hordiienko.history.repositories;

import com.hordiienko.history.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
}
