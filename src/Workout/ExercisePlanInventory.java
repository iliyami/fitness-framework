
package Workout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Exercise.Exercise;

// using singleton
public class ExercisePlanInventory {
    private static ExercisePlanInventory singleExercisePlanInventory = null;
    private List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
  
    public static ExercisePlanInventory getInstance()
    {
        if (singleExercisePlanInventory == null){
            singleExercisePlanInventory = new ExercisePlanInventory();
        }
        return singleExercisePlanInventory;
    }

    public ExercisePlan getExercisePlanByExercise(Exercise exercise){
        Iterator<ExercisePlan> iterator = this.exercisePlans.iterator();
        while (iterator.hasNext()) {
            ExercisePlan exercisePlan = iterator.next();
            if (exercisePlan.getExercise().equals(exercise)) {
                return exercisePlan;
            }
        }
        return null;
    }

    public void addOrUpdateExercisePlan(ExercisePlan exercisePlan){
        ExercisePlan existedExercisePlan = getExercisePlanByExercise(exercisePlan.getExercise());
        deleteExercisePlan(existedExercisePlan);
        this.exercisePlans.add(exercisePlan);
    }

    public void deleteExercisePlan(ExercisePlan exercisePlan){
        exercisePlans.remove(exercisePlan);
    }
}