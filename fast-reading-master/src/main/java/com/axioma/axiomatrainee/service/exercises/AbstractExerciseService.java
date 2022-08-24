package com.axioma.axiomatrainee.service.exercises;

import com.axioma.axiomatrainee.model.exercises.Exercise;
import com.axioma.axiomatrainee.model.exercises.ExerciseType;

import java.util.List;
import java.util.Optional;

public interface AbstractExerciseService{

    List<Exercise> findAll();

    Optional<Exercise> findById(Long id, ExerciseType type);

    void deleteById(Long id);

    Exercise save(Exercise exercise);
}
