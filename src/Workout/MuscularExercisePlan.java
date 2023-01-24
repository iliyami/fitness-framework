package Workout;

import java.time.LocalTime;

import Exercise.Exercise;

public class MuscularExercisePlan extends ExercisePlan {
    private int rep;
    private int set;
    private LocalTime rest;

    public MuscularExercisePlan(
        int id, int weight, Exercise exercise, int rep, int set, LocalTime rest){
            super(id, weight, exercise);            
            this.setRep(rep);
            this.setRest(rest);
            this.setSet(set);
            this.addOrUpdateExercisePlanInInventory();
    }

    public int getRep() {
        return rep;
    }

    private void setRep(int rep) {
        this.rep = rep;
    }

    public LocalTime getRest() {
        return rest;
    }

    private void setRest(LocalTime rest) {
        this.rest = rest;
    }

    public int getSet() {
        return set;
    }

    private void setSet(int set) {
        this.set = set;
    }

    public void updateExercisePlan(
        int weight, Exercise exercise, int rep, int set, LocalTime rest){
            super.updateExercisePlan(weight, exercise);
            this.setRep(rep);
            this.setRest(rest);
            this.setSet(set);
            this.addOrUpdateExercisePlanInInventory();
    }
}