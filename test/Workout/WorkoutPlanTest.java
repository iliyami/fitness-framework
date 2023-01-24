package test.Workout;

import static org.junit.Assert.*;

import org.junit.Test;

import WorkoutPlan.WorkoutPlan;
import WorkoutPlan.WorkoutPlanInventory;

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
        WorkoutPlanInventory workoutPlanInventory = new WorkoutPlanInventory();
    }

    Exercise deadliftExercise;
    MuscularExercisePlan deadliftExercisePlan;
    List<ExercisePlan> exercisePlans;
    WorkoutPlanInventory workoutPlanInventory;

    @Test
    public void testCreateWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, 'my workout', exercisePlans
        );
    }

    @Test
    public void testWorkoutPlanGetters() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, 'my workout', exercisePlans
        );
        assertEquals(workoutPlan.getId(), 1);
        assertEquals(workoutPlan.getName(), 'my workout');
        assertEquals(workoutPlan.getExercisePlans().Length(), 1);
    }

    @Test
    public void testUpdateWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, 'my workout', exercisePlans
        );
        workoutPlan.editPlan('new workout', exercisePlans)
        assertEquals(workoutPlan.getId(), 1);
        assertEquals(workoutPlan.getName(), 'new workout');
    }

    @Test
    public void testgetWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, 'my workout', exercisePlans
        );
        foundWorkoutPlan = workoutPlanInventory.getWorkoutPlanById(1)
        assertEquals(workoutPlan, foundWorkoutPlan);
    }

    @Test
    public void testdeleteWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan(
            1, 'my workout', exercisePlans
        );
        workoutPlanInventory.deleteWorkoutPlan(workoutPlan);
        foundWorkoutPlan = workoutPlanInventory.getWorkoutPlanById(1)
        assertEquals(foundWorkoutPlan, null);
    }

}