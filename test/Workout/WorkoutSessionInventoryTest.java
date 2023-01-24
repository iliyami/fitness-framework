package test.Workout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Workout.ExercisePlan;
import Workout.WorkoutPlan;
import Workout.WorkoutSession;
import Workout.WorkoutSessionInventory;

public class WorkoutSessionInventoryTest {
    public WorkoutSessionInventoryTest() {
        mocWorkoutSession = new WorkoutSession(0, new WorkoutPlan(0, "Test", exercisePlans));
    }

    private WorkoutSessionInventory workoutSessionInventory = WorkoutSessionInventory.getInstance();
    List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
    private WorkoutSession mocWorkoutSession;
    
    @Test
    public void testCreateWorkoutSessionInventory() {
        
        workoutSessionInventory.addOrUpdateWorkoutSession(mocWorkoutSession);
        assertNotEquals(null, workoutSessionInventory.getWorkoutSessionById(mocWorkoutSession.getId()));
        assertEquals(workoutSessionInventory.getWorkoutSessions().size(), workoutSessionInventory.workoutSessionsCount());
    }

    @Test
    public void testDeleteWorkoutPlanInventory() {
        workoutSessionInventory.addOrUpdateWorkoutSession(mocWorkoutSession);
        assertEquals(mocWorkoutSession, workoutSessionInventory.getWorkoutSessionById(mocWorkoutSession.getId()));
        workoutSessionInventory.deleteWorkoutSession(mocWorkoutSession);
        assertEquals(null, workoutSessionInventory.getWorkoutSessionById(mocWorkoutSession.getId()));
    }

    @Test
    public void testUpdateWorkoutPlanInventory() {
        
        workoutSessionInventory.addOrUpdateWorkoutSession(mocWorkoutSession);
        workoutSessionInventory.addOrUpdateWorkoutSession(mocWorkoutSession);
        workoutSessionInventory.addOrUpdateWorkoutSession(mocWorkoutSession);
        assertEquals(1, workoutSessionInventory.workoutSessionsCount());
    }
}
