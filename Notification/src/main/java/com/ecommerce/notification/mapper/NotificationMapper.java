package com.ecommerce.notification.mapper;

import com.ecommerce.notification.dto.NotificationRequestDto;
import com.ecommerce.notification.dto.NotificationResponseDto;
import com.ecommerce.notification.dto.OrderCreatedEvent;
import com.ecommerce.notification.model.Notification;

import java.time.LocalDateTime;

public class NotificationMapper {

    public static NotificationResponseDto toDto(Notification notification){
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();

        notificationResponseDto.setId( String.valueOf(notification.getId()));
        notificationResponseDto.setOrder_id(String.valueOf(notification.getOrderId()));
        notificationResponseDto.setMessage(notification.getMessage());
        notificationResponseDto.setStatus(notification.getStatus());

        return notificationResponseDto;
    }

    public static Notification toModel(NotificationRequestDto notificationRequestDto){
        Notification notification = new Notification();

        notification.setId(Integer.valueOf(notificationRequestDto.getId()));
        notification.setOrderId(Integer.valueOf(notificationRequestDto.getOrder_id()));
        notification.setMessage(notificationRequestDto.getMessage());
        notification.setStatus(notificationRequestDto.getStatus());

        return notification;
    }

    public static Notification toEntity(OrderCreatedEvent event) {

        Notification analytics = new Notification();

        analytics.setOrderId(Math.toIntExact(event.getOrderId()));
        analytics.setMessage("Order created");
        analytics.setStatus("Pending");

        return analytics;
    }
}
