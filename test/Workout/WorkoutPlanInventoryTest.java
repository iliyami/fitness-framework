package test.Workout;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Workout.ExercisePlan;
import Workout.WorkoutPlan;
import Workout.WorkoutPlanInventory;

public class WorkoutPlanInventoryTest {
    List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
    WorkoutPlanInventory workoutPlanInventory = WorkoutPlanInventory.getInstance();
    
    @Test
    public void testCreateWorkoutPlanInventory() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        workoutPlan.addWorkoutPlanInInventory(workoutPlan);
        assertEquals(workoutPlan, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()));
    }

    @Test
    public void testUpdateWorkoutPlanInventory() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        String newName = "test";
        workoutPlan.editPlan(newName, exercisePlans);
        workoutPlanInventory.UpdateWorkoutPlan(workoutPlan);
        assertEquals(newName, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()).getName());
    }

    @Test
    public void testDeleteWorkoutPlanInventory() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        workoutPlanInventory.addWorkoutPlan(workoutPlan);
        assertEquals(workoutPlan, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()));
        workoutPlanInventory.deleteWorkoutPlan(workoutPlan);
        assertEquals(null, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()));
    }
}
