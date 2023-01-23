package test.Notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import Notification.SMSNotification;
import Notification.EmailNotification;
import Notification.PushNotification;

public class NotificationTest {
    SMSNotification smsNotification;
    EmailNotification emailNotification;
    PushNotification pushNotification;

    public NotificationTest() {
        smsNotification = new SMSNotification(1, 1, LocalDateTime.now(), "09123456789");
        emailNotification = new EmailNotification(2, 2, LocalDateTime.now(), "google@gmail.com");
        pushNotification = new PushNotification(3, 3, LocalDateTime.now(), "ae13c589s");
    }

    @Test
    public void testNotificationsGetId() {
        assertEquals(smsNotification.getId() + 1, emailNotification.getId());
        assertEquals(smsNotification.getId() + 2, pushNotification.getId());
        assertEquals(emailNotification.getId() + 1, pushNotification.getId());
    }

    @Test
    public void testNotificationsIdsAreUniq() {
        assertNotEquals(smsNotification.getId(), emailNotification.getId());
        assertNotEquals(smsNotification.getId(), pushNotification.getId());
        assertNotEquals(emailNotification.getId(), pushNotification.getId());
    }

    @Test
    public void testNotificationsGetUserId() {
        assertEquals(1, smsNotification.getUserId());
        assertEquals(2, emailNotification.getUserId());
        assertEquals(3, pushNotification.getUserId());
    }

    @Test
    public void testNotificationsGetWorkoutPlanId() {
        assertEquals(1, smsNotification.getWorkoutPlanId());
        assertEquals(2, emailNotification.getWorkoutPlanId());
        assertEquals(3, pushNotification.getWorkoutPlanId());
    }

    @Test
    public void testNotificationsGetDateTime() {
        assertEquals(LocalDateTime.class, smsNotification.getDateTime().getClass());
        assertEquals(LocalDateTime.class, emailNotification.getDateTime().getClass());
        assertEquals(LocalDateTime.class, pushNotification.getDateTime().getClass());
    }

}