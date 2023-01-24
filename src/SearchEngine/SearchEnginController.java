package SearchEngine;


public class SearchEnginController {
    private SearchExerciseController searchExerciseController;
    private SearchWorkoutHistoryController searchWorkoutHistoryController;

    public void setSearchExerciseController(SearchExerciseController searchExerciseController) {
        this.searchExerciseController = searchExerciseController;
    }

    public SearchEnginController() {
        setSearchExerciseController(new SearchExerciseController());
        setSearchWorkoutHistoryController(new SearchWorkoutHistoryController());
    }


    public void setSearchWorkoutHistoryController(SearchWorkoutHistoryController searchWorkoutHistoryController) {
        this.searchWorkoutHistoryController = searchWorkoutHistoryController;
    }

    public SearchExerciseController getSearchExerciseController() {
        return searchExerciseController;
    }

    public SearchWorkoutHistoryController getSearchWorkoutHistoryController() {
        return searchWorkoutHistoryController;
    }
}