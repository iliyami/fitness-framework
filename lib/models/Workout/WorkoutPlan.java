package Workout;

import java.util.List;

public class WorkoutPlan {
    private int id;
    private String name;
    private List<ExercisePlan> exercisePlans;

    public WorkoutPlan(int id, String name, List<ExercisePlan> exercisePlans) {
        this.setId(id);
        this.setName(name);
        this.setExercisePlans(exercisePlans);
    }

    public List<ExercisePlan> getExercisePlans() {
        return exercisePlans;
    }

    private void setExercisePlans(List<ExercisePlan> exercisePlans) {
        this.exercisePlans = exercisePlans;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public WorkoutPlan getWorkoutPlanById(int id){
            WorkoutPlan dummyWorkoutPlan = new WorkoutPlan(1, "name", null);
            return dummyWorkoutPlan;
        }

    public WorkoutPlan editPlan(
        WorkoutPlan plan, String name, List<ExercisePlan> exercisePlans){
            WorkoutPlan dummyWorkoutPlan = new WorkoutPlan(1, "name", null);
            return dummyWorkoutPlan;
        }
}