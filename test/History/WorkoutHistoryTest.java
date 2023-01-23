package test.History;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import History.WorkoutHistory;
import Workout.WorkoutPlan;
import Workout.WorkoutSession;

public class WorkoutHistoryTest {
    WorkoutHistory mockWorkoutHistory;

    public WorkoutHistoryTest() {
        this.mockWorkoutHistory = new WorkoutHistory(new WorkoutSession(new WorkoutPlan(0, "Lorem", new ArrayList<>())));
    }

    @Test
    public void testCreateWorkoutHistory() {
        final WorkoutHistory newWorkoutHistory = mockWorkoutHistory.getWorkoutHistory(new WorkoutSession(new WorkoutPlan(0, "test", new ArrayList<>())));
        assertNotEquals(newWorkoutHistory.getId(), mockWorkoutHistory.getId());
    }

    @Test
    public void testWorkoutSession() {
        final WorkoutSession newWorkoutSession = new WorkoutSession(new WorkoutPlan(1, "Lorem Test", new ArrayList<>()));
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
        mockWorkoutHistory.updateWorkoutHistory(new WorkoutSession(new WorkoutPlan(100, "test-test", new ArrayList<>())));
        assertNotEquals(oldWorkoutHistoryTimeStamp, mockWorkoutHistory.getTimestamp());
        assertNotEquals(oldId, mockWorkoutHistory.getWorkoutSession().getPlan().getId());
    }
}