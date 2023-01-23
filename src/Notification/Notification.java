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

    public void printNotificationInfo() {
        System.out.printf("notification id: %d", this.id);
        System.out.printf("user id: %d", this.userId);
        System.out.printf("workout plan id: %d", this.workoutPlanId);
        System.out.printf("notification date time: %s", this.dateTime);
    }

    public abstract void update();
}

class SMSNotification extends Notification {
    private String phoneNumber;

    public SMSNotification(int id, int userId, int workoutPlanId, LocalDateTime dateTime, String phoneNumber) {
        super(id, userId, workoutPlanId, dateTime);
        this.phoneNumber = phoneNumber;
    }

    public void update() {
        System.out.println("sending SMS notification:");
        System.out.printf("user phone number: %s", this.phoneNumber);
        this.printNotificationInfo();
    }
}

class EmailNotification extends Notification {
    private String email;

    public EmailNotification(int id, int userId, int workoutPlanId, LocalDateTime dateTime, String email) {
        super(id, userId, workoutPlanId, dateTime);
        this.email = email;
    }

    public void update() {
        System.out.println("sending email notification:");
        System.out.printf("user email: %s", this.email);
        this.printNotificationInfo();
    }
}

class PushNotification extends Notification {
    private String deviceId;

    public PushNotification(int id, int userId, int workoutPlanId, LocalDateTime dateTime, String deviceId) {
        super(id, userId, workoutPlanId, dateTime);
        this.deviceId = deviceId;
    }

    public void update() {
        System.out.println("sending push notification:");
        System.out.printf("user device id: %s", this.deviceId);
        this.printNotificationInfo();
    }
}
