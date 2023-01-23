package test.Exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Exercise.BodyPart;
import Exercise.Muscle;

public class MuscleTest {
    @Test
    public void testGetID() {
        Muscle mockMuscle = new Muscle("Lorem", BodyPart.LOWERBODY);
        final String newMuscleName = "Test";
        final BodyPart newBodyPart = BodyPart.UPPERBODY;
        mockMuscle.setName(newMuscleName);
        mockMuscle.setBodyPart(newBodyPart);
        assertEquals(newMuscleName, mockMuscle.getName());
        assertEquals(newBodyPart, mockMuscle.getBodyPart());
    }
}
