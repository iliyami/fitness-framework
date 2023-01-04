package Workout;

import java.time.LocalDateTime;

public class WorkoutSession {
    private WorkoutPlan plan;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public void startSession(final WorkoutPlan plan) {
        this.setStartTime(LocalDateTime.now());
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public WorkoutPlan getPlan() {
        return plan;
    }

    public void setPlan(final WorkoutPlan plan) {
        this.plan = plan;
    }

    public void finishSession(final WorkoutPlan plan) {
        this.setFinishTime(LocalDateTime.now());

    }
}