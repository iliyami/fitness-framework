package Workout;

import Exercise.Exercise;

// where and how to set id? where is it used?
// there will be at most one exercise plan per exercise

public class ExercisePlan {
    private Exercise exercise;
    private int id;
    private float weight;

    public ExercisePlan(int id, int weight, Exercise exercise){
        this.setId(id);
        this.setWeight(weight);
        this.setExercise(exercise);
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

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void updateExercisePlan(int weight, Exercise exercise){
        this.weight = weight;
        this.exercise = exercise;
    }

    public void addOrUpdateExercisePlanInInventory(){
        exercisePlanInventory = ExercisePlanInventory.getInstance();
        exercisePlanInventory.addOrUpdateExercisePlan(this);
    }
}