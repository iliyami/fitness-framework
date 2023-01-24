package SearchEngine;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;

import History.WorkoutHistory;
import History.WorkoutHistoryController;

public class SearchWorkoutHistoryController {
    private WorkoutHistoryController workoutHistoryController;

    public SearchWorkoutHistoryController(WorkoutHistoryController workoutHistoryController) {
        setWorkoutHistoryController(workoutHistoryController);
    }

    public WorkoutHistoryController getWorkoutHistoryController() {
        return workoutHistoryController;
    }

    public void setWorkoutHistoryController(WorkoutHistoryController workoutHistoryController) {
        this.workoutHistoryController = workoutHistoryController;
    }

    public WorkoutHistory getHistoryById(int id) {
        return null;
    }

    public WorkoutHistory getHistoryByIndex(int index) {
        return null;
    }

    public WorkoutHistory getHistoryByWorkoutPlan(int id){
        return null;
    }

    public List<WorkoutHistory> getHistoriesByTimeRange(LocalDateTime start, LocalDateTime end){
        return null;
    }

    public List<WorkoutHistory> getHistoriesByExercisePlan(int id){
        return null;
    }

    public List<WorkoutHistory> getHistoriesFilteredByClaAmount(int cals){
        return null;
    }

    public List<WorkoutHistory> getHistoriesFilteredByReps(int reps){
        return null;
    }

    public List<WorkoutHistory> getHistoriesFilteredByRest(LocalTime rest){
        return null;
    }

    public List<WorkoutHistory> getHistoriesFilteredByWeight(float weight){
        return null;
    }
}