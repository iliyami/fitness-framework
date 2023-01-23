package SearchEngine;

import java.util.List;

import Exercise.Exercise;
import Exercise.ExerciseInventory;
import Exercise.ExerciseType;

public class SearchExerciseController {
    public ExerciseInventory exerciseInventory;

    public SearchExerciseController(ExerciseInventory exerciseInventory) {
        this.exerciseInventory = exerciseInventory;
    }

    public Exercise getExerciseById(int id){
        return null;
    }
    public List<Exercise> getExerciseByType(ExerciseType exerciseType){
        return null;
    }
    public List<Exercise> getExerciseByPopularity(int popularity){
        return null;
    }
    public List<Exercise> getExerciseByName(String name){
        return null;
    }
}