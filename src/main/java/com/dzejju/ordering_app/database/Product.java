package com.dzejju.ordering_app.database;

import lombok.Builder;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;


    protected Product() {
    }

    public Product(String name) {
        this.Name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

}