package Workout;

import java.time.LocalDateTime;

public class WorkoutSession {
    private WorkoutPlan plan;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public WorkoutSession(WorkoutPlan plan){
        this.setPlan(plan);
    }

    public void startSession() {
        System.out.println("Session started...");
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

    public void finishSession() {
        this.setFinishTime(LocalDateTime.now());
        System.out.println("Session finished...");
    }

    @Override
    public String toString() {
        return "WorkoutSession [plan=" + plan + ", startTime=" + startTime + ", finishTime=" + finishTime + "]";
    }
}