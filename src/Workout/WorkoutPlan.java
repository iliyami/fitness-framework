package Workout;

import java.util.List;

// where and how to set id?
public class WorkoutPlan {
    private int id;
    private String name;
    private List<ExercisePlan> exercisePlans;

    public WorkoutPlan(int id, String name, List<ExercisePlan> exercisePlans) {
        this.setId(id);
        this.setName(name);
        this.setExercisePlans(exercisePlans);
        addWorkoutPlanInInventory(this);
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

    public void editPlan(String name, List<ExercisePlan> exercisePlans){
        setName(name);
        setExercisePlans(exercisePlans);
        UpdateWorkoutPlanInInventory(this);
    }

    public void addWorkoutPlanInInventory(WorkoutPlan workoutPlan){
        workoutPlanInInventory = WorkoutPlanInInventory.getInstance();
        workoutPlanInInventory.UpdateWorkoutPlan(workoutPlan);
    }

    public void UpdateWorkoutPlanInInventory(WorkoutPlan workoutPlan){
        workoutPlanInInventory = WorkoutPlanInInventory.getInstance();
        workoutPlanInInventory.UpdateWorkoutPlan(workoutPlan);
    }
}