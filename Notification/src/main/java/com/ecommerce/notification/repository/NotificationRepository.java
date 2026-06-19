package com.ecommerce.notification.repository;

import com.ecommerce.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Notification getByOrderId(int id);
}
