package com.example.placementmodule.controller;

import com.example.placementmodule.model.Notification;
import com.example.placementmodule.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long userId) {
        List<Notification> notifications = notificationRepository.findByUserIdAndRead(userId, false);
        return ResponseEntity.ok(notifications);
    }

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody Notification notification) {
        notificationRepository.save(notification);
        return ResponseEntity.ok("Notification sent successfully");
    }

}

