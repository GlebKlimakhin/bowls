package com.axioma.axiomatrainee.api;

import com.axioma.axiomatrainee.model.exercises.Exercise;
import com.axioma.axiomatrainee.model.exercises.ExerciseType;
import com.axioma.axiomatrainee.service.exercises.ExerciseService;
import com.axioma.axiomatrainee.service.exercises.RandomExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/reading")
public class ReadingSpeedExerciseController {

    private ExerciseService exerciseService;
    private RandomExerciseService randomExerciseService;
    public static final ExerciseType TYPE = ExerciseType.READING_SPEED;
    @Autowired
    public void setService(ExerciseService service, RandomExerciseService randomExerciseService) {
        this.exerciseService = service;
        this.randomExerciseService = randomExerciseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('user')")
    public Set<Exercise> findAll() {
        return exerciseService.findAllByType(TYPE);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('user')")
    public Exercise findById(@PathVariable Long id) {
        return exerciseService.findById(id, TYPE).orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('admin')")
    public void deleteById(Long id) {
        exerciseService.findAllByType(TYPE).forEach(e -> {
            if(e.getId().equals(id)) {
                exerciseService.deleteById(id);
            }
        });
        exerciseService.findAll();
    }

    @GetMapping("/random/userId={userId}")
    @PreAuthorize("hasAuthority('user')")
    public Exercise findRandomByUserId(@PathVariable Long userId) {
        return randomExerciseService.findRandomByUserId(userId, TYPE);
    }

}
