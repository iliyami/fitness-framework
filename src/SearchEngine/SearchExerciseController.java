package SearchEngine;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import Exercise.*;

public class SearchExerciseController {
    private ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();

    public Exercise getExerciseById(int id){
        Iterator<Exercise> iterator = exerciseInventory.getExercises().iterator();
        while (iterator.hasNext()) {
            Exercise exercise = iterator.next();
            if (exercise.getId() == id) {
                return exercise;
            }
        }
        return null;
    }
    
    public List<Exercise> getExerciseByType(ExerciseType exerciseType){
        List<Exercise> result = new ArrayList<Exercise>();
        Iterator<Exercise> iterator = exerciseInventory.getExercises().iterator();
        while (iterator.hasNext()) {
            Exercise exercise = iterator.next();
            if (exercise.getExerciseType().equals(exerciseType)) {
                result.add(exercise);
            }
        }
        return result;
    }

    public List<Exercise> getExerciseByPopularity(int popularity){
        List<Exercise> result = new ArrayList<Exercise>();
        Iterator<Exercise> iterator = exerciseInventory.getExercises().iterator();
        while (iterator.hasNext()) {
            Exercise exercise = iterator.next();
            if (exercise.getPopularity() == popularity) {
                result.add(exercise);
            }
        }
        return result;
    }

    public List<Exercise> getExerciseByName(String name){
        List<Exercise> result = new ArrayList<Exercise>();
        Iterator<Exercise> iterator = exerciseInventory.getExercises().iterator();
        while (iterator.hasNext()) {
            Exercise exercise = iterator.next();
            if (exercise.getName() == name) {
                result.add(exercise);
            }
        }
        return result;
    }
}