package com.ecommerce.product.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {

    private String id;

    private String name;

    private String category;

    private String price;

    private String stock;

}

