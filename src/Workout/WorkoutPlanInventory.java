
package Workout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// using singleton
public class  WorkoutPlanInventory {
    private static WorkoutPlanInventory singleWorkoutPlanInventory = null;
    private List<WorkoutPlan> workoutPlans= new ArrayList<WorkoutPlan>();
  
    public static WorkoutPlanInventory getInstance()
    {
        if (singleWorkoutPlanInventory == null) {
            singleWorkoutPlanInventory = new WorkoutPlanInventory();
        }
        return singleWorkoutPlanInventory;
    }

    public WorkoutPlan getWorkoutPlanById(int id){
        Iterator<WorkoutPlan> iterator = this.workoutPlans.iterator();
        while (iterator.hasNext()) {
            WorkoutPlan workoutPlan = iterator.next();
            if (workoutPlan.getId() == id) {
                return workoutPlan;
            }
        }
        return null;
    }

    public void addWorkoutPlan(WorkoutPlan workoutPlan){
        WorkoutPlan existedWorkoutPlan = getWorkoutPlanById(workoutPlan.getId());
        if (existedWorkoutPlan == null)
            this.workoutPlans.add(workoutPlan); 
    }

    public void UpdateWorkoutPlan(WorkoutPlan workoutPlan){
        WorkoutPlan existedWorkoutPlan = getWorkoutPlanById(workoutPlan.getId());
        if(existedWorkoutPlan != null)
            deleteWorkoutPlan(existedWorkoutPlan);
        this.workoutPlans.add(workoutPlan);
    }

    public void deleteWorkoutPlan(WorkoutPlan workoutPlan){
        workoutPlans.remove(workoutPlan);
    }
}