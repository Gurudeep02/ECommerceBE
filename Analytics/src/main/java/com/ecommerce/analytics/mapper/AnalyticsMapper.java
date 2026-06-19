package com.ecommerce.analytics.mapper;

import com.ecommerce.analytics.dto.OrderCreatedEvent;
import com.ecommerce.analytics.model.OrderAnalytics;

import java.time.LocalDateTime;

public class AnalyticsMapper {

    public static OrderAnalytics toEntity(OrderCreatedEvent event) {

        OrderAnalytics analytics = new OrderAnalytics();

        analytics.setOrderId(event.getOrderId());
        analytics.setProductId(event.getProductId());
        analytics.setQuantity(event.getQuantity());
        analytics.setTotalAmount(event.getTotalAmount());
        analytics.setCreatedAt(LocalDateTime.now());

        return analytics;
    }
}