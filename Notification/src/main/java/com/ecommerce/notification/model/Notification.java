package com.ecommerce.notification.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Notification {

    @Id
    private int id;

    @Column(name = "order_id")
    private int orderId;

    private String message;

    private String status;
}
