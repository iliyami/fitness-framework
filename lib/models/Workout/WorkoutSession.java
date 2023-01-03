package Workout;

import java.time.LocalDateTime;

public class WorkoutSession {
    private WorkoutPlan plan;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public void startSession(final WorkoutPlan plan) {
        this.startTime = LocalDateTime.now();
    }

    public WorkoutPlan getPlan() {
        return plan;
    }

    public void setPlan(final WorkoutPlan plan) {
        this.plan = plan;
    }

    public void finishSession(final WorkoutPlan plan) {
        this.finishTime = LocalDateTime.now();

    }
}