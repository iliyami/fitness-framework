package History;

import java.util.List;

import Workout.WorkoutSession;

public class WorkoutHistoryController {
    private static final Boolean True = null;
    private WorkoutHistoryController historyController;
    private List<WorkoutHistory> workoutHistories;

    private WorkoutHistoryController(WorkoutHistoryController historyController,
            List<WorkoutHistory> workoutHistories) {
        this.setHistoryController(historyController);
        this.setWorkoutHistories(workoutHistories);
    }

    public List<WorkoutHistory> getWorkoutHistories() {
        return workoutHistories;
    }

    private void setWorkoutHistories(List<WorkoutHistory> workoutHistories) {
        this.workoutHistories = workoutHistories;
    }

    public WorkoutHistoryController getHistoryController() {
        return historyController;
    }

    private void setHistoryController(WorkoutHistoryController historyController) {
        this.historyController = historyController;
    }

    public WorkoutHistoryController getInstance() {
        return this;
    }

    public Boolean saveHistory(WorkoutSession session) {
        return True;
    }

    public Boolean updateHistory(String id, WorkoutSession session) {
        return True;
    }

    public Boolean deleteHistory(String id) {
        return True;
    }
}