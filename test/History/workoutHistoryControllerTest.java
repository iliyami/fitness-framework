package test.History;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import History.WorkoutHistory;
import History.WorkoutHistoryController;
import Workout.WorkoutPlan;
import Workout.WorkoutSession;

public class workoutHistoryControllerTest {
    WorkoutHistoryController mockWorkoutHistoryController;

    public workoutHistoryControllerTest() {
        mockWorkoutHistoryController = WorkoutHistoryController.getInstance();
    }

    @Test
    public void testPattern() {
        
        assertNotEquals(null, mockWorkoutHistoryController);
    }

    @Test
    public void testWorkoutHistories() {
        final ArrayList<WorkoutHistory> newWorkoutHistories = new ArrayList<>();
        newWorkoutHistories.add(new WorkoutHistory(new WorkoutSession(new WorkoutPlan(120, "test", null))));
        mockWorkoutHistoryController.setWorkoutHistories(newWorkoutHistories);
        assertEquals(newWorkoutHistories.get(0).getId(), mockWorkoutHistoryController.getWorkoutHistories().get(0).getId());
    }

    @Test
    public void testSavingWorkoutHistory() {
        final WorkoutSession newSession = new WorkoutSession(new WorkoutPlan(14, "Test", null));
        mockWorkoutHistoryController.saveHistory(newSession);
        assertEquals(newSession, mockWorkoutHistoryController.getWorkoutHistories().get(mockWorkoutHistoryController.getWorkoutHistories().size() - 1).getWorkoutSession());
    }

    @Test
    public void testUpdatingHistory() {
        WorkoutSession newSession = new WorkoutSession(new WorkoutPlan(14, "Test", null));
        mockWorkoutHistoryController.saveHistory(newSession);
        final int newSessionWorkoutPlanId = 0;
        newSession = new WorkoutSession(new WorkoutPlan(newSessionWorkoutPlanId, "Test", null));
        final boolean result = mockWorkoutHistoryController.updateHistory(mockWorkoutHistoryController.getWorkoutHistories().get(mockWorkoutHistoryController.getWorkoutHistories().size() - 1).getId(), newSession);
        assertEquals(true, result);
        assertEquals(newSessionWorkoutPlanId, mockWorkoutHistoryController.getWorkoutHistories().get(mockWorkoutHistoryController.getWorkoutHistories().size() - 1).getWorkoutSession().getPlan().getId());
    }

    @Test
    public void testDeletingHistory() {
        WorkoutSession newSession = new WorkoutSession(new WorkoutPlan(14, "Test", null));
        WorkoutSession newSession2 = new WorkoutSession(new WorkoutPlan(12, "Test", null));
        mockWorkoutHistoryController.saveHistory(newSession);
        mockWorkoutHistoryController.saveHistory(newSession2);
        final int newSessionWorkoutPlanId = mockWorkoutHistoryController.getWorkoutHistories().get(mockWorkoutHistoryController.getWorkoutHistories().size() - 1).getWorkoutSession().getPlan().getId();
        final int deleteItemId = mockWorkoutHistoryController.getWorkoutHistories().get(mockWorkoutHistoryController.getWorkoutHistories().size() - 1).getId();
        final boolean result = mockWorkoutHistoryController.deleteHistory(deleteItemId);
        assertEquals(true, result);
        assertNotEquals(newSessionWorkoutPlanId, mockWorkoutHistoryController.getWorkoutHistories().get(mockWorkoutHistoryController.getWorkoutHistories().size() - 1).getId());
    }
}
