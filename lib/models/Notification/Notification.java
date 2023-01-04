package Notification;

import java.time.LocalDateTime;

public abstract class Notification {
    private int id;
    private int userId;
    private int workoutPlanId;
    private LocalDateTime dateTime;

    public Notification(int id, int userId, int workoutPlanId, LocalDateTime dateTime) {
        this.id = id;
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

    public abstract void notifySubscribers();
}

class SMSNotification extends Notification {
    private String phoneNumber;

    public SMSNotification(int id, int userId, int workoutPlanId, LocalDateTime dateTime, String phoneNumber) {
        super(id, userId, workoutPlanId, dateTime);
        this.phoneNumber = phoneNumber;
    }

    public void notifySubscribers() {
        return;
    }
}

class EmailNotification extends Notification {
    private String email;

    public EmailNotification(int id, int userId, int workoutPlanId, LocalDateTime dateTime, String email) {
        super(id, userId, workoutPlanId, dateTime);
        this.email = email;
    }

    public void notifySubscribers() {
        return;
    }
}

class PushNotification extends Notification {
    private String deviceId;

    public PushNotification(int id, int userId, int workoutPlanId, LocalDateTime dateTime, String deviceId) {
        super(id, userId, workoutPlanId, dateTime);
        this.deviceId = deviceId;
    }

    public void notifySubscribers() {
        return;
    }
}

