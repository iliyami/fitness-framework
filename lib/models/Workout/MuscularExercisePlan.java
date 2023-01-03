package Workout;

import java.time.LocalTime;

import Exercise.Exercise;

public class MuscularExercisePlan extends ExercisePlan {
    private int rep;
    private int set;
    private LocalTime rest;

    public MuscularExercisePlan(
        int id, int weight, Exercise exercise, int rep, int set, LocalTime rest){
            this.setId(id);
            this.setWeight(weight);
            this.setExercise(exercise);
            this.setRep(rep);
            this.setRest(rest);
            this.setSet(set);
    }

    public int getRep() {
        return rep;
    }

    public LocalTime getRest() {
        return rest;
    }

    public void setRest(LocalTime rest) {
        this.rest = rest;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public boolean updateExercisePlan(
        int id, int weight, Exercise exercise, int rep, int set, LocalTime rest){
            return true;
    }
}