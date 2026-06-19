package com.ecommerce.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "productdb")
public class Product {

    @Id
    private int id;

    private String name;

    private String category;

    private String price;

    private int stock;

}
