package com.ecommerce.analytics.controller;

import com.ecommerce.analytics.model.OrderAnalytics;
import com.ecommerce.analytics.repository.AnalyticsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsRepository repository;

    public AnalyticsController(AnalyticsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<OrderAnalytics> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public OrderAnalytics getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}