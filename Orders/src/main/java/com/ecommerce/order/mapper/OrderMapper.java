package com.ecommerce.order.mapper;

import com.ecommerce.order.dto.OrderRequestDto;
import com.ecommerce.order.dto.OrderResponseDto;
import com.ecommerce.order.model.Order;
import lombok.Data;

@Data
public class OrderMapper {

    public static Order toModel(OrderRequestDto orderRequestDto){
        Order order = new Order();

        order.setId(Integer.parseInt(orderRequestDto.getOrderId()));
        order.setQuantity(orderRequestDto.getQuantity());
        order.setStatus(orderRequestDto.getStatus());
        order.setTotal_amount(orderRequestDto.getTotalAmount());
        order.setProduct_id(Integer.parseInt(orderRequestDto.getProductId()));

        return order;
    }

    public static OrderResponseDto toDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setOrderId(String.valueOf(order.getId()));
        orderResponseDto.setQuantity(order.getQuantity());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setTotalAmount(order.getTotal_amount());
        orderResponseDto.setProductId(String.valueOf(order.getProduct_id()));

        return orderResponseDto;
    }
}
