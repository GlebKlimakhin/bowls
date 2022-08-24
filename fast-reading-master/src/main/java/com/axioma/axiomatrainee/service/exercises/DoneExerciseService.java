package com.axioma.axiomatrainee.service.exercises;

import com.axioma.axiomatrainee.model.exercises.DoneExercise;
import com.axioma.axiomatrainee.model.exercises.DoneExerciseId;
import com.axioma.axiomatrainee.model.exercises.ExerciseType;
import com.axioma.axiomatrainee.repository.IDoneExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoneExerciseService {

    private IDoneExercisesRepository doneExercisesRepository;

    @Autowired
    public void setDoneExercisesRepository(IDoneExercisesRepository doneExercisesRepository) {
        this.doneExercisesRepository = doneExercisesRepository;
    }

    public List<DoneExercise> findAllByUserIdAndType(Long userId, ExerciseType type) {
        return doneExercisesRepository.findAllByDoneExerciseId_UseridAndExerciseType(userId, type);
    }

    public List<DoneExercise> findAllByUserId(Long userId) {
        return doneExercisesRepository.findAllByDoneExerciseId_Userid(userId);
    }

    public DoneExercise save(DoneExercise doneExercise) {
        return doneExercisesRepository.save(doneExercise);
    }
}
