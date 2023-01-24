package SearchEngine;


public class SearchEnginController {
    private SearchExerciseController searchExerciseController;
    private SearchWorkoutHistoryController searchWorkoutHistoryController;

    public SearchExerciseController getSearchExerciseController() {
        return searchExerciseController;
    }

    public SearchWorkoutHistoryController getSearchWorkoutHistoryController() {
        return searchWorkoutHistoryController;
    }
}