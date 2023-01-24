package Workout;

import java.time.LocalDateTime;

public class WorkoutSession {
	private int id;
    private WorkoutPlan plan;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private WorkoutSessionInventory workoutSessionInventory = WorkoutSessionInventory.getInstance();

    public WorkoutSession(int id, WorkoutPlan plan){
    	this.setId(id);
        this.setPlan(plan);
        workoutSessionInventory.addOrUpdateWorkoutSession(this);
    }
    
    private void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return this.id;
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
}