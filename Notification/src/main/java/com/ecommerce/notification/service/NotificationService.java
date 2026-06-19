package com.ecommerce.notification.service;

import com.ecommerce.notification.dto.NotificationRequestDto;
import com.ecommerce.notification.dto.NotificationResponseDto;
import com.ecommerce.notification.dto.OrderCreatedEvent;
import com.ecommerce.notification.mapper.NotificationMapper;
import com.ecommerce.notification.model.Notification;
import com.ecommerce.notification.repository.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    @KafkaListener(
            topics = "order-created",
            groupId = "notification-group")
    public void consume(OrderCreatedEvent event) {

        System.out.println(
                "Notification Received");

        notificationRepository.save(NotificationMapper.toEntity(event));

        System.out.println("Saved analytics record for orderId: " + event.getOrderId());
    }
    
    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public NotificationResponseDto saveNotifiaction(NotificationRequestDto notificationRequestDto){
        Notification notification = NotificationMapper.toModel(notificationRequestDto);

        return NotificationMapper.toDto(notificationRepository.save(notification));
    }

    public NotificationResponseDto getNotificationByOrderId(int id){
        return NotificationMapper.toDto(notificationRepository.getByOrderId(id));
    }
}
