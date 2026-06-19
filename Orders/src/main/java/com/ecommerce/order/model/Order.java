package com.ecommerce.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "orderdb")
public class Order {

    @Id
    @Column(name = "order_id")
    private int id;

    private int product_id;

    private String quantity;

    private String total_amount;

    private String status;
}
