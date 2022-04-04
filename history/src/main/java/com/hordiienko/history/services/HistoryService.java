package com.hordiienko.history.services;

import com.hordiienko.history.models.Exercise;

import java.util.List;

public interface HistoryService {

    List<Exercise> getRandomExercise(int amount);

    void setVersion(int version);

    int getVersion();

    void fillDB();
}
