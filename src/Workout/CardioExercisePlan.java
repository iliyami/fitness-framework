package Workout;

import java.time.LocalDateTime;
import java.time.LocalTime;

import Exercise.Exercise;

public class CardioExercisePlan extends ExercisePlan {
    private LocalTime duration;
    private int calAmount;
    private int interval;

    public CardioExercisePlan(
            int weight, Exercise exercise, int calAmount, int interval, LocalTime duration) {
        super(LocalDateTime.now().hashCode(), weight, exercise);
        this.setCalAmount(calAmount);
        this.setInterval(interval);
        this.setDuration(duration);
        this.addOrUpdateExercisePlanInInventory();
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

    public void updateExercisePlan(
            int weight, Exercise exercise, int calAmount, int interval, LocalTime duration) {
        super.updateExercisePlan(weight, exercise);
        this.calAmount = calAmount;
        this.interval = interval;
        this.duration = duration;
        this.addOrUpdateExercisePlanInInventory();
    }
}