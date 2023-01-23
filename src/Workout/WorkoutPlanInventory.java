
package Workout;

import java.util.List;

// using singleton
public class  WorkoutPlanInventory {
    private static WorkoutPlanInventory singleWorkoutPlanInventory = null;
    private List<WorkoutPlan> workoutPlans = new List<WorkoutPlan>();
  
    public static WorkoutPlanInventory getInstance()
    {
        if (singleWorkoutPlanInventory == null)
            singleWorkoutPlanInventory = new WorkoutPlanInventory();
  
        return singleWorkoutPlanInventory;
    }

    public ExercisePlan getWorkoutPlanById(int id){
        return workoutPlans.filter(id=id);
    }

    public void addWorkoutPlan(WorkoutPlan workoutPlan){
        existedWorkoutPlan = getWorkoutPlanById(workoutPlan.id);
        if (existedWorkoutPlan == null)
            this.workoutPlans.add(workoutPlan); 
    }

    public void UpdateWorkoutPlan(WorkoutPlan workoutPlan){
        existedWorkoutPlan = getWorkoutPlanById(workoutPlan.id);
        deleteWorkoutPlan(existedWorkoutPlan);
        this.workoutPlans.add(workoutPlan);
    }

    public void deleteWorkoutPlan(WorkoutPlan workoutPlan){
        workoutPlans.remove(workoutPlan);
    }
}