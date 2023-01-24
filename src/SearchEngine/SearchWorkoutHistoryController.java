package SearchEngine;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import Exercise.Exercise;
import Exercise.ExerciseType;

import java.time.LocalDateTime;

import History.WorkoutHistory;
import History.WorkoutHistoryController;
import Workout.CardioExercisePlan;
import Workout.ExercisePlan;
import Workout.MuscularExercisePlan;
import Workout.WorkoutPlan;

public class SearchWorkoutHistoryController {
    private WorkoutHistoryController workoutHistoryController;

    public SearchWorkoutHistoryController() {
    	WorkoutHistoryController workoutHistoryController = WorkoutHistoryController.getInstance();
        setWorkoutHistoryController(workoutHistoryController);
    }
    
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
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            if (workoutHistory.getId() == id) {
                return workoutHistory;
            }
        }
        return null;
    }

    public WorkoutHistory getHistoryByIndex(int index) {
        return workoutHistoryController.getWorkoutHistories().get(index);
    }

    public WorkoutHistory getHistoryByWorkoutPlan(int id){
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            if (workoutHistory.getWorkoutSession().getPlan().getId() == id) {
                return workoutHistory;
            }
        }
        return null;
    }

    public List<WorkoutHistory> getHistoriesByTimeRange(LocalDateTime start, LocalDateTime end){
        List<WorkoutHistory> result = new ArrayList<WorkoutHistory>();
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            if (workoutHistory.getTimestamp().isBefore(end) && workoutHistory.getTimestamp().isAfter(start)) {
                result.add(workoutHistory);
            }
        }
        return result;
    }

    public List<WorkoutHistory> getHistoriesByExercisePlan(int id){
        List<WorkoutHistory> result = new ArrayList<WorkoutHistory>();
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            WorkoutPlan workoutPlan = workoutHistory.getWorkoutSession().getPlan();
            Iterator<ExercisePlan> exercisePlanIterator = workoutPlan.getExercisePlans().iterator();
            while (exercisePlanIterator.hasNext()) {
            	ExercisePlan exercisePlan = exercisePlanIterator.next();
                if (exercisePlan.getId() == id) {
                    result.add(workoutHistory);
                    break;
                }
            }
        }
        return result;
    }

    public List<WorkoutHistory> getHistoriesFilteredByCalAmount(int cals){
        List<WorkoutHistory> result = new ArrayList<WorkoutHistory>();
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            WorkoutPlan workoutPlan = workoutHistory.getWorkoutSession().getPlan();
            Iterator<ExercisePlan> exercisePlanIterator = workoutPlan.getExercisePlans().iterator();
            while (exercisePlanIterator.hasNext()) {
            	ExercisePlan exercisePlan = exercisePlanIterator.next();
                if (exercisePlan.getExercise().getExerciseType() == ExerciseType.CARDIOVASCULAR && ((CardioExercisePlan)exercisePlan).getCalAmount() == cals) {
                    result.add(workoutHistory);
                    break;
                }
            }
        }
        return result;
    }

    public List<WorkoutHistory> getHistoriesFilteredByReps(int reps){
        List<WorkoutHistory> result = new ArrayList<WorkoutHistory>();
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            WorkoutPlan workoutPlan = workoutHistory.getWorkoutSession().getPlan();
            Iterator<ExercisePlan> exercisePlanIterator = workoutPlan.getExercisePlans().iterator();
            while (exercisePlanIterator.hasNext()) {
            	ExercisePlan exercisePlan = exercisePlanIterator.next();
                if (exercisePlan.getExercise().getExerciseType() == ExerciseType.MUSCULAR && ((MuscularExercisePlan) exercisePlan).getRep() == reps) {
                	result.add(workoutHistory);
                    break;
                }
            }
        }
        return result;
    }

    public List<WorkoutHistory> getHistoriesFilteredByExercise(Exercise exercise){
        List<WorkoutHistory> result = new ArrayList<WorkoutHistory>();
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            WorkoutPlan workoutPlan = workoutHistory.getWorkoutSession().getPlan();
            Iterator<ExercisePlan> exercisePlanIterator = workoutPlan.getExercisePlans().iterator();
            while (exercisePlanIterator.hasNext()) {
            	ExercisePlan exercisePlan = exercisePlanIterator.next();
                if (exercisePlan.getExercise().equals(exercise)) {
                    result.add(workoutHistory);
                    break;
                }
            }
        }
        return result;
    }

    public List<WorkoutHistory> getHistoriesFilteredByWeight(float weight){
        List<WorkoutHistory> result = new ArrayList<WorkoutHistory>();
        Iterator<WorkoutHistory> iterator = workoutHistoryController.getWorkoutHistories().iterator();
        while (iterator.hasNext()) {
            WorkoutHistory workoutHistory = iterator.next();
            WorkoutPlan workoutPlan = workoutHistory.getWorkoutSession().getPlan();
            Iterator<ExercisePlan> exercisePlanIterator = workoutPlan.getExercisePlans().iterator();
            while (exercisePlanIterator.hasNext()) {
            	ExercisePlan exercisePlan = exercisePlanIterator.next();
                if (exercisePlan.getWeight() == weight) {
                    result.add(workoutHistory);
                    break;
                }
            }
        }
        return result;
    }
}