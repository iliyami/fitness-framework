package test.Exercise;

import static org.junit.Assert.*;

import org.junit.Test;

import Exercise.BodyPart;
import Exercise.Exercise;
import Exercise.ExerciseType;
import Exercise.Muscle;

/**
 * ExerciseTest
 */
public class ExerciseTest {

    public ExerciseTest() {
        mockExercise = new Exercise(0, "Pull-ups", "Grab the bars with your hands and pull urself up.", 9, ExerciseType.MUSCULAR, new Muscle("Lats", BodyPart.UPPERBODY));
    }

    Exercise mockExercise;

    @Test
    public void testGetID() {
        assertEquals(0, mockExercise.getId());
    }

    @Test
    public void testMuscle() {
        final String newName = "Lorem";
        final BodyPart newBodyPart = BodyPart.LOWERBODY;
        mockExercise.setTargetMuscle(new Muscle(newName, newBodyPart));
        final Muscle muscle = mockExercise.getTargetMuscle();
        assertEquals(newName, muscle.getName());
        assertEquals(newBodyPart, muscle.getBodyPart());
    }

    @Test
    public void testName() {
        final String newName = "Push-ups";
        mockExercise.setName(newName);
        assertEquals(newName, mockExercise.getName());
    }

    @Test
    public void testInstruction() {
        final String newInstruction = "test";
        mockExercise.setInstruction(newInstruction);
        assertEquals(newInstruction, mockExercise.getInstruction());
    }

    @Test
    public void testPopularity() {
        final int newPopularity = 4;
        mockExercise.setPopularity(newPopularity);
        assertEquals(newPopularity, mockExercise.getPopularity());
    }

    @Test
    public void testExerciseType() {
        final ExerciseType newExerciseType = ExerciseType.CARDIOVASCULAR;
        mockExercise.setExerciseType(newExerciseType);
        assertEquals(newExerciseType, mockExercise.getExerciseType());
    }

    @Test
    public void testUpdateExercise() {
        final String newExerciseName = "Lorem Ipsum";
        final String newMuscleName = "Push-ups-test";
        final String newInstruction = "test-test";
        final int newPopularity = 2;
        final ExerciseType newExerciseType = ExerciseType.CARDIOVASCULAR;
        final BodyPart newBodyPart = BodyPart.LOWERBODY;
        final Muscle newMuscle = new Muscle(newMuscleName, newBodyPart);
        mockExercise.updateExercise(newExerciseName, newInstruction, newPopularity, newExerciseType, newMuscle);
        assertEquals(newExerciseType, mockExercise.getExerciseType());
        assertEquals(newPopularity, mockExercise.getPopularity());
        assertEquals(newInstruction, mockExercise.getInstruction());
        assertEquals(newExerciseName, mockExercise.getName());
        assertEquals(newMuscle, mockExercise.getTargetMuscle());
    }
}