package Notification;

import java.time.LocalDateTime;

public abstract class Notification {
    private static int count = 0;
    private int id;
    private int userId;
    private int workoutPlanId;
    private LocalDateTime dateTime;

    public Notification(int userId, int workoutPlanId, LocalDateTime dateTime) {
        this.id = count++;
        this.userId = userId;
        this.workoutPlanId = workoutPlanId;
        this.dateTime = dateTime;
    }

    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getWorkoutPlanId() {
        return this.workoutPlanId;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void printNotificationInfo() {
        System.out.printf("notification id: %d\n", this.id);
        System.out.printf("user id: %d\n", this.userId);
        System.out.printf("workout plan id: %d\n", this.workoutPlanId);
        System.out.printf("notification date time: %s\n", this.dateTime);
    }

    public abstract void update();
}
