package com.dzejju.ordering_app.database;

import javax.persistence.*;

@Entity
public class OrderItems {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long orderID;
    private Long productID;
    private Integer amount;

    protected OrderItems() {
    }


    public OrderItems(Long orderID, Long productID, Integer amount) {
        this.orderID = orderID;
        this.productID = productID;
        this.amount = amount;
    }
}