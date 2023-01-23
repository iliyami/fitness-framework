package Notification;

import java.time.LocalDateTime;

public class SMSNotification extends Notification {
    private String phoneNumber;

    public SMSNotification(int userId, int workoutPlanId, LocalDateTime dateTime, String phoneNumber) {
        super(userId, workoutPlanId, dateTime);
        this.phoneNumber = phoneNumber;
    }

    public void update() {
        System.out.println("sending SMS notification:");
        System.out.printf("user phone number: %s\n", this.phoneNumber);
        this.printNotificationInfo();
    }
}