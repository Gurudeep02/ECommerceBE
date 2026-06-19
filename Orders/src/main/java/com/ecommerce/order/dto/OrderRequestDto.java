package com.ecommerce.order.dto;

import lombok.Data;

@Data
public class OrderRequestDto {

    private String orderId;
    private String productId;
    private String quantity;
    private String totalAmount;
    private String status;

}
