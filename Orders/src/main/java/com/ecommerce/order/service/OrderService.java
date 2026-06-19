package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderCreatedEvent;
import com.ecommerce.order.dto.OrderRequestDto;
import com.ecommerce.order.dto.OrderResponseDto;
import com.ecommerce.order.mapper.OrderMapper;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate){
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public OrderResponseDto saveOrder(OrderRequestDto orderRequestDto){

         Order order = OrderMapper.toModel(orderRequestDto);
         int productId = order.getProduct_id();

         restTemplate.put("http://product-service:9090/products/reduceStock?quantity="+order.getQuantity()+"&product_id="+productId, null);

         orderRepository.save(order);

        OrderCreatedEvent event =
                new OrderCreatedEvent();

        event.setOrderId((long) order.getId());

        event.setProductId((long) order.getProduct_id());

        event.setQuantity(Integer.valueOf(order.getQuantity()));

        event.setTotalAmount(Double.valueOf(order.getTotal_amount()));
        publish(event);
         return OrderMapper.toDto(order);
    }


    public void publish(OrderCreatedEvent event) {

        kafkaTemplate.send(
                "order-created",
                event);

        System.out.println(
                "Order Event Published");
    }

}
