package Workout;

import Exercise.Exercise;

public class ExercisePlan {
    private Exercise exercise;
    private int id;
    private float weight;

    public Exercise getExercise() {
        return exercise;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public ExercisePlan getExercisePlan(int id){
        return null;
    }

    public boolean deleteExercisePlan(int id){
        return true;
    }
}