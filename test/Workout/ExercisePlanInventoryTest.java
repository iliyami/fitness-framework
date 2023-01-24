package test.Workout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Exercise.BodyPart;
import Exercise.Exercise;
import Exercise.ExerciseType;
import Exercise.Muscle;
import Workout.ExercisePlan;
import Workout.ExercisePlanInventory;

public class ExercisePlanInventoryTest {
    public ExercisePlanInventoryTest() {
        exercisePlanInventory.getExercisePlans().clear();
        deadliftExercise = new Exercise(
			1, "deadlift", "how to do deadlift explanation", 90, ExerciseType.MUSCULAR, new Muscle("Deltoid - Lats", BodyPart.UPPERBODY)
        );

        mockExercisePlan = new ExercisePlan(0, 0, deadliftExercise);
    }
    
    Exercise deadliftExercise;
    Exercise runningExercise;
    ExercisePlan mockExercisePlan;
    final ExercisePlanInventory  exercisePlanInventory = ExercisePlanInventory.getInstance();

    @Test
    public void testCreateWorkoutSessionInventory() {
        exercisePlanInventory.addOrUpdateExercisePlan(mockExercisePlan);
        assertNotEquals(null, exercisePlanInventory.getExercisePlanById(mockExercisePlan.getId()));
    }

    @Test
    public void testDeleteWorkoutPlanInventory() {
        exercisePlanInventory.addOrUpdateExercisePlan(mockExercisePlan);
        assertEquals(mockExercisePlan, exercisePlanInventory.getExercisePlanById(mockExercisePlan.getId()));
        exercisePlanInventory.deleteExercisePlan(mockExercisePlan);
        assertEquals(null, exercisePlanInventory.getExercisePlanById(mockExercisePlan.getId()));
    }

    @Test
    public void testUpdateWorkoutPlanInventory() {
        
        exercisePlanInventory.addOrUpdateExercisePlan(mockExercisePlan);
        exercisePlanInventory.addOrUpdateExercisePlan(mockExercisePlan);
        exercisePlanInventory.addOrUpdateExercisePlan(mockExercisePlan);
        assertEquals(1, exercisePlanInventory.getExercisePlans().size());
    }
}
