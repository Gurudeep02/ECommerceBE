package com.ecommerce.product.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private String id;

    private String name;

    private String category;

    private String price;
}
