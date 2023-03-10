package test.Workout;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import Exercise.BodyPart;
import Exercise.Exercise;
import Exercise.ExerciseType;
import Exercise.Muscle;
import Workout.MuscularExercisePlan;
import Workout.CardioExercisePlan;

public class ExercisePlanTest {

    Exercise deadliftExercise;
    Exercise runningExercise;
    private static final double DELTA = 1e-15;

    public ExercisePlanTest() {
        deadliftExercise = new Exercise(
			1, "deadlift", "how to do deadlift explanation", 90, ExerciseType.MUSCULAR, new Muscle("Deltoid - Lats", BodyPart.UPPERBODY)
        );
        runningExercise = new Exercise(
			1, "running", "how to do running explanation", 90, ExerciseType.CARDIOVASCULAR, new Muscle("Deltoid - Lats", BodyPart.UPPERBODY)
        );
    }


    @Test
    public void testCreateUpdateMuscularExercisePlan() {
        final int newWeight = 20;
        MuscularExercisePlan deadliftExercisePlan = new MuscularExercisePlan(
			newWeight, deadliftExercise, 10, 3, LocalTime.of(0,1,30)
        );
        assertEquals(deadliftExercisePlan.getWeight(), newWeight, DELTA);
        deadliftExercisePlan.updateExercisePlan(30, deadliftExercise, 8, 3, LocalTime.of(0,1,30));
        assertEquals(deadliftExercisePlan.getWeight(), 30, DELTA);
    }

    @Test
    public void testMuscularExercisePlanGetters() {
        MuscularExercisePlan deadliftExercisePlan = new MuscularExercisePlan(
			20, deadliftExercise, 10, 3, LocalTime.of(0,1,30)
        );
        assertEquals(deadliftExercisePlan.getWeight(), 20, DELTA);
        assertEquals(deadliftExercisePlan.getExercise(), deadliftExercise);
        assertEquals(deadliftExercisePlan.getRep(), 10);
        assertEquals(deadliftExercisePlan.getSet(), 3);
        assertEquals(deadliftExercisePlan.getRest(), LocalTime.of(0,1,30));
    }

    @Test
    public void testCreateUpdateCardioExercisePlan() {
        CardioExercisePlan runningExercisePlan = new CardioExercisePlan(
			20, runningExercise, 10, 3, LocalTime.of(0,1,30)
        );
        assertEquals(runningExercisePlan.getWeight(), 20, DELTA);
        runningExercisePlan.updateExercisePlan(30, deadliftExercise, 8, 3, LocalTime.of(0,1,30));
        assertEquals(runningExercisePlan.getWeight(), 30, DELTA);
    }

    @Test
    public void testCardioExercisePlanGetters() {
        CardioExercisePlan runningExercisePlan = new CardioExercisePlan(
			20, runningExercise, 10, 3, LocalTime.of(0,1,30)
        );
        runningExercisePlan.setExercise(deadliftExercise);
        assertEquals(runningExercisePlan.getWeight(), 20, DELTA);
        assertEquals(runningExercisePlan.getExercise(), deadliftExercise);
        assertEquals(runningExercisePlan.getCalAmount(), 10);
        assertEquals(runningExercisePlan.getInterval(), 3);
        assertEquals(runningExercisePlan.getDuration(), LocalTime.of(0,1,30));
    }

}