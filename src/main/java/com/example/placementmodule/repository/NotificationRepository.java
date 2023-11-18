package com.example.placementmodule.repository;

import com.example.placementmodule.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserIdAndRead(Long userId, boolean read);

}
