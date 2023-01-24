package test.History;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import History.WorkoutHistory;
import Workout.WorkoutPlan;
import Workout.WorkoutSession;

public class WorkoutHistoryTest {
    WorkoutHistory mockWorkoutHistory;

    public WorkoutHistoryTest() {
        this.mockWorkoutHistory = new WorkoutHistory(new WorkoutSession(0, new WorkoutPlan(0, "Lorem", new ArrayList<>())));
    }

    @Test
    public void testCreateWorkoutHistory() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        final WorkoutHistory newWorkoutHistory = mockWorkoutHistory.getWorkoutHistory(new WorkoutSession(0, new WorkoutPlan(0, "test", new ArrayList<>())));
        assertNotEquals(newWorkoutHistory.getId(), mockWorkoutHistory.getId());
    }

    @Test
    public void testWorkoutSession() {
        final WorkoutSession newWorkoutSession = new WorkoutSession(0, new WorkoutPlan(1, "Lorem Test", new ArrayList<>()));
        mockWorkoutHistory.setWorkoutSession(newWorkoutSession);
        assertEquals(newWorkoutSession, mockWorkoutHistory.getWorkoutSession());
    }

    @Test
    public void testTimestamp() {
        final LocalDateTime newDatetime = LocalDateTime.now();
        mockWorkoutHistory.setTimestamp(newDatetime);
        assertEquals(newDatetime, mockWorkoutHistory.getTimestamp());
    }

    @Test
    public void testUpdateWorkoutHistory() {
        final LocalDateTime oldWorkoutHistoryTimeStamp = mockWorkoutHistory.getTimestamp();
        final int oldId = mockWorkoutHistory.getWorkoutSession().getPlan().getId();
        mockWorkoutHistory.updateWorkoutHistory(new WorkoutSession(oldId, new WorkoutPlan(100, "test-test", new ArrayList<>())));
        assertNotEquals(oldWorkoutHistoryTimeStamp, mockWorkoutHistory.getTimestamp());
        assertNotEquals(oldId, mockWorkoutHistory.getWorkoutSession().getPlan().getId());
    }
}
