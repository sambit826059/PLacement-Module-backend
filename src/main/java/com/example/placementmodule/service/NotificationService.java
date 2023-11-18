// NotificationService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    List<Notification> getAllNotifications();

    Optional<Notification> getNotificationById(Long id);

    Notification createNotification(Notification notification);

    Notification updateNotification(Long id, Notification updatedNotification);

    void deleteNotification(Long id);
}
