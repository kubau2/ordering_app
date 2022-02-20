package com.dzejju.ordering_app.database;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String tags;


    protected Product() {
    }

    public Product(String name, Double price, String tags) {
        this.name = name;
        this.price = price;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }
}