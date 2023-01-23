package Notification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<Notification> subscribers;

    public NotificationManager() {
        this.subscribers = new ArrayList<Notification>();
    }

    public void subscribe(Notification notification) {
        this.subscribers.add(notification);
    }

    public void unsubscribe(int notificationId) {
        this.subscribers.removeIf(subscriber -> subscriber.getId() == notificationId);
    }

    public void notifySubscribers() {
        List<Notification> newSubscribers = new ArrayList<Notification>();
        for (Notification notification : subscribers) {
            if (notification.getDateTime().isAfter(LocalDateTime.now())) {
                notification.update();
            }else {
                newSubscribers.add(notification);
            }
        }
        this.subscribers = newSubscribers;
    }
}