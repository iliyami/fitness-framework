package Workout;

import java.time.LocalTime;

import Exercise.Exercise;

public class CardioExercisePlan extends ExercisePlan {
    private LocalTime duration;
    private int calAmount;
    private int interval;

    public CardioExercisePlan(
        int id, int weight, Exercise exercise, int calAmount, int interval, LocalTime duration){
            this.setId(id);
            this.setWeight(weight);
            this.setExercise(exercise);
            this.setCalAmount(calAmount);
            this.setInterval(interval);
            this.setDuration(duration);
    }

    public LocalTime getDuration() {
        return duration;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getCalAmount() {
        return calAmount;
    }

    public void setCalAmount(int calAmount) {
        this.calAmount = calAmount;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public boolean updateExercisePlan(
        int id, int weight, Exercise exercise, int calAmount, int interval, LocalTime duration){
            return true;
    }
}