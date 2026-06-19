package com.ecommerce.analytics.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_analytics")
@Data
public class OrderAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double totalAmount;

    private LocalDateTime createdAt;
}