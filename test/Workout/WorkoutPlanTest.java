package test.Workout;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Exercise.*;
import Workout.*;

public class WorkoutPlanTest {

    public WorkoutPlanTest() {
        deadliftExercise = new Exercise(
			1, "deadlift", "how to do deadlift explanation", 90, ExerciseType.MUSCULAR, new Muscle("Deltoid - Lats", BodyPart.UPPERBODY)
        );
        deadliftExercisePlan = new MuscularExercisePlan(
			20, deadliftExercise, 10, 3, LocalTime.of(0,1,30)
        );
        List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
        exercisePlans.add(deadliftExercisePlan);
    }

    Exercise deadliftExercise;
    MuscularExercisePlan deadliftExercisePlan;
    List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
    WorkoutPlanInventory workoutPlanInventory = WorkoutPlanInventory.getInstance();

    @Test
    public void testCreateWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        workoutPlan.addWorkoutPlanInInventory(workoutPlan);
        assertEquals(workoutPlan, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()));
    }

    @Test
    public void testWorkoutPlanGetters() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        assertEquals(workoutPlan.getId(), 1);
        assertEquals(workoutPlan.getName(), "my workout");
        assertEquals(0, workoutPlan.getExercisePlans().size());
    }

    @Test
    public void testUpdateWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        final String newName = "new workout";
        workoutPlan.editPlan(newName, exercisePlans);
        assertEquals(1, workoutPlan.getId());
        assertEquals(newName, workoutPlan.getName());
    }

    @Test
    public void testUpdateWorkoutPlanInventory() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        final String newName = "new workout";
        workoutPlan.editPlan(newName, exercisePlans);
        workoutPlan.addWorkoutPlanInInventory(workoutPlan);
        workoutPlan.UpdateWorkoutPlanInInventory(workoutPlan);
        assertEquals(newName, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()).getName());
    }

    @Test
    public void testgetWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        final WorkoutPlan foundWorkoutPlan = workoutPlanInventory.getWorkoutPlanById(1);
        assertEquals(foundWorkoutPlan, workoutPlan);
    }

    @Test
    public void testdeleteWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, "my workout", exercisePlans
        );
        workoutPlan.addWorkoutPlanInInventory(workoutPlan);
        assertEquals(workoutPlan, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()));
        workoutPlanInventory.deleteWorkoutPlan(workoutPlan);
        assertEquals(null, workoutPlanInventory.getWorkoutPlanById(workoutPlan.getId()));
    }

}