package com.ecommerce.notification.controller;

import com.ecommerce.notification.dto.NotificationRequestDto;
import com.ecommerce.notification.dto.NotificationResponseDto;
import com.ecommerce.notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping
    public NotificationResponseDto saveNotification(NotificationRequestDto notificationRequestDto){
        return notificationService.saveNotifiaction(notificationRequestDto);
    }

    @GetMapping("/order/{orderId}")
    public NotificationResponseDto getgNotificationByOrder(@PathVariable(value = "orderId") int id){
        return notificationService.getNotificationByOrderId(id);
    }
}
