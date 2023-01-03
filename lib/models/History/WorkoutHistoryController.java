package History;

import java.util.List;

import Workout.WorkoutSession;

public class WorkoutHistoryController {
    private static final Boolean True = null;
    private WorkoutHistoryController historyController;
    private List<WorkoutHistory> workoutHistories;

    private WorkoutHistoryController(
        WorkoutHistoryController historyController,
        List<WorkoutHistory> workoutHistories){
            this.historyController = historyController;
            this.workoutHistories = workoutHistories;
        }
    
    public WorkoutHistoryController getInstance(){
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