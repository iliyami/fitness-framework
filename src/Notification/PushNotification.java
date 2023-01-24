package Notification;

import java.time.LocalDateTime;

public class PushNotification extends Notification {
    private String deviceId;

    public PushNotification(int userId, int workoutPlanId, LocalDateTime dateTime, String deviceId) {
        super(userId, workoutPlanId, dateTime);
        this.deviceId = deviceId;
    }

    public void update() {
        System.out.println("sending push notification:");
        System.out.printf("user device id: %s\n", this.deviceId);
        this.printNotificationInfo();
    }
}
