package com.dzejju.ordering_app.database;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;


    protected Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}