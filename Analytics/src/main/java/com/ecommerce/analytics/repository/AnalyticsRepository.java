package com.ecommerce.analytics.repository;

import com.ecommerce.analytics.model.OrderAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsRepository extends JpaRepository<OrderAnalytics, Long> {
}