package com.ecommerce.notification.dto;

import lombok.Data;

@Data
public class NotificationRequestDto {

    private String id;

    private String order_id;

    private String message;

    private String status;

}
