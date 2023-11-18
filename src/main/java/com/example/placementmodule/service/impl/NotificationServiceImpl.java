// NotificationServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.Notification;
import com.example.placementmodule.repository.NotificationRepository;
import com.example.placementmodule.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, Notification updatedNotification) {
        Optional<Notification> existingNotification = notificationRepository.findById(id);

        if (existingNotification.isPresent()) {
            Notification notification = existingNotification.get();
            // Update the fields you want to update
            if (updatedNotification.getUserId() != null) {
                notification.setUserId(updatedNotification.getUserId());
            }

            if (updatedNotification.getMessage() != null) {
                notification.setMessage(updatedNotification.getMessage());
            }

            notification.setRead(updatedNotification.isRead());

            // ... update other fields as needed

            return notificationRepository.save(notification);
        } else {
            // Handle the case where the Notification with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
