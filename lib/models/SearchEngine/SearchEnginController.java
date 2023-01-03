package SearchEngine;

import java.util.List;

import Exercise.Exercise;
import Workout.WorkoutPlan;

public class SearchEnginController {
    private SearchExerciseController searchExerciseController;
    private SearchWorkoutHistoryController searchWorkoutHistoryController;

    public SearchExerciseController getSearchExerciseController() {
        return searchExerciseController;
    }

    public SearchWorkoutHistoryController getSearchWorkoutHistoryController() {
        return searchWorkoutHistoryController;
    }

    public List<Exercise> searchExercisesByName(String name){
        return null;
    }

    public List<WorkoutPlan> searchWorkoutPlansByName(String name){
        return null;
    }

}