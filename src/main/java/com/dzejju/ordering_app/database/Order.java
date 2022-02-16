package com.dzejju.ordering_app.database;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long orderID;
    private Long customerID;
    private Long productID;
    private Integer amount;

    protected Order() {
    }


    public Order(Long orderID, Long customerID, Long productID, Integer amount) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.productID = productID;
        this.amount = amount;
    }
}