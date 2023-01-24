package test.Workout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import Workout.ExercisePlan;
import Workout.WorkoutPlan;
import Workout.WorkoutSession;
import Workout.WorkoutSessionInventory;

public class WorkoutSessionTest {
    public WorkoutSessionTest() {
        mocWorkoutSession = new WorkoutSession(0, new WorkoutPlan(0, "Test", exercisePlans));
    }

    private WorkoutSessionInventory workoutSessionInventory = WorkoutSessionInventory.getInstance();
    List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
    private WorkoutSession mocWorkoutSession;

    @Test
    public void testCreateWorkoutSession() {
        final int newID = 101;
        final WorkoutSession newWorkoutSession = new WorkoutSession(newID, new WorkoutPlan(0, "Test", exercisePlans));
        assertEquals(newID, newWorkoutSession.getId());

        assertNotEquals(null, workoutSessionInventory.getWorkoutSessionById(newID));
    }

    @Test
    public void testStartStopSession() throws InterruptedException {
        LocalDateTime start = mocWorkoutSession.getStartTime();
        assertEquals(null, start);

        LocalDateTime stop = mocWorkoutSession.getFinishTime();
        assertEquals(null, stop);

        mocWorkoutSession.startSession();
        start = mocWorkoutSession.getStartTime();
        assertNotEquals(null, start);

        TimeUnit.SECONDS.sleep(1);
        mocWorkoutSession.finishSession();
        stop = mocWorkoutSession.getFinishTime();
        assertNotEquals(null, stop);
        assertNotEquals(start, stop);
        assertNotEquals(start, stop);
    }
}
