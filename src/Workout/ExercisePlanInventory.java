
package Workout;

import java.util.List;

// using singleton
public class ExercisePlanInventory {
    private static ExercisePlanInventory singleExercisePlanInventory = null;
    private List<ExercisePlan> exercisePlans = new List<ExercisePlan>();
  
    public static ExercisePlanInventory getInstance()
    {
        if (singleExercisePlanInventory == null)
            singleExercisePlanInventory = new ExercisePlanInventory();
  
        return singleExercisePlanInventory;
    }

    public ExercisePlan getExercisePlanByExercise(Exercise exercise){
        return exercisePlans.filter(exercise=exercise);
    }

    public void addOrUpdateExercisePlan(ExercisePlan exercisePlan){
        existedExercisePlan = getExercisePlanByExercise(exercisePlan.exercise);
        deleteExercisePlan(existedExercisePlan);
        this.exercisePlans.add(exercisePlan);
    }

    public void deleteExercisePlan(ExercisePlan exercisePlan){
        exercisePlans.remove(exercisePlan);
    }
}