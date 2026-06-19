package com.ecommerce.analytics.service;

import com.ecommerce.analytics.dto.OrderCreatedEvent;
import com.ecommerce.analytics.mapper.AnalyticsMapper;
import com.ecommerce.analytics.model.OrderAnalytics;
import com.ecommerce.analytics.repository.AnalyticsRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    private final AnalyticsRepository repository;

    public AnalyticsService(AnalyticsRepository repository) {
        this.repository = repository;
    }

    // Kafka Consumer
    @KafkaListener(topics = "order-created", groupId = "analytics-group")
    public void consume(OrderCreatedEvent event) {

        System.out.println("Analytics received event: " + event);

        OrderAnalytics entity = AnalyticsMapper.toEntity(event);

        repository.save(entity);

        System.out.println("Saved analytics record for orderId: " + event.getOrderId());
    }
}