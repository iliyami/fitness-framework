package Notification;

import java.time.LocalDateTime;

public class EmailNotification extends Notification {
    private String email;

    public EmailNotification(int userId, int workoutPlanId, LocalDateTime dateTime, String email) {
        super(userId, workoutPlanId, dateTime);
        this.email = email;
    }

    public void update() {
        System.out.println("sending email notification:");
        System.out.printf("user email: %s\n", this.email);
        this.printNotificationInfo();
    }
}