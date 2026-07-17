package com.careerforge.notification.listener;

import com.careerforge.notification.event.NotificationEvent;
import com.careerforge.notification.service.NotificationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

    private final NotificationService notificationService;

    public NotificationEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @EventListener
    public void handleNotificationEvent(NotificationEvent event) {
        notificationService.createNotification(event.getStudent(), event.getMessage());
    }
}
