package com.hordiienko.history.services;

import com.hordiienko.history.models.Exercise;
import com.hordiienko.history.repositories.ExerciseRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    @Setter
    private ExerciseRepo exerciseRepo;

    @Setter
    @Getter
    private int version;


    @Override
    @EventListener(ContextRefreshedEvent.class)
    public void fillDB() {
        System.out.println("filling db with some data");
        List<Exercise> exercises = Arrays.asList(
                Exercise.builder().question("How old is Java?").answer("22").build(),
                Exercise.builder().question("How old is Groovy?").answer("16").build()
        );
        exerciseRepo.saveAll(exercises);
    }

    @Override
    public List<Exercise> getRandomExercise(int amount) {
        List<Exercise> all = exerciseRepo.findAll();
        Collections.shuffle(all);
        return all.subList(0, amount);
    }
}
