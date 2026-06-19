package com.ecommerce.order.controller;

import com.ecommerce.order.dto.OrderRequestDto;
import com.ecommerce.order.dto.OrderResponseDto;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> saveOrder(@RequestBody OrderRequestDto orderRequestDto){
        return ResponseEntity.ok(orderService.saveOrder(orderRequestDto));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<OrderResponseDto> getOrderByProductId(@PathVariable int id){
//        return ResponseEntity.ok(orderService.getOrderByProductId(id));
//    }
}
