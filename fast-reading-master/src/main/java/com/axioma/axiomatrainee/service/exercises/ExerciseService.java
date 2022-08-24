package com.axioma.axiomatrainee.service.exercises;

import com.axioma.axiomatrainee.model.exercises.Exercise;
import com.axioma.axiomatrainee.model.exercises.ExerciseType;
import com.axioma.axiomatrainee.repository.IExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseService implements AbstractExerciseService{

    private IExerciseRepository exerciseRepository;

    @Autowired
    public void setExerciseRepository(IExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Optional<Exercise> findById(Long id, ExerciseType type) {
        return exerciseRepository.findByIdAndExerciseTypeEquals(id, type);
    }

    @Override
    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Set<Exercise> findAllByType(ExerciseType exerciseType) {
        return exerciseRepository.findAllByExerciseTypeEquals(exerciseType);
    }
}
