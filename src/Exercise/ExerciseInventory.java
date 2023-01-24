
package Exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// using singleton
public class ExerciseInventory {
    private static ExerciseInventory singleExerciseInventory = null;
    private List<Exercise> exercises = new ArrayList<Exercise>();
  
    public List<Exercise> getExercises() {
        return exercises;
    }

    public static ExerciseInventory getInstance()
    {
        if (singleExerciseInventory == null){
            singleExerciseInventory = new ExerciseInventory();
        }
        return singleExerciseInventory;
    }

    public List<Exercise> getExercises(){
        return exercises;
    }

    public Exercise getExerciseById(int id){
        Iterator<Exercise> iterator = this.exercises.iterator();
        while (iterator.hasNext()) {
            Exercise exercise = iterator.next();
            if (exercise.getId() == id) {
                return exercise;
            }
        }
        return null;
    }

    public void addExercise(Exercise exercise){
        Exercise existedexercise = getExerciseById(exercise.getId());
        if (existedexercise == null)
            this.exercises.add(exercise); 
    }

    public void updateExercise(Exercise exercise){
        Exercise existedexercise = getExerciseById(exercise.getId());
        if(existedexercise != null)
            deleteExercise(existedexercise);
        this.exercises.add(exercise);
    }

    public boolean deleteExercise(Exercise exercise){
        return exercises.remove(exercise);
    }
}