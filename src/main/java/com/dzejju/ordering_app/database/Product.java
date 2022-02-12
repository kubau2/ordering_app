package com.dzejju.ordering_app.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private int Availability;

    protected Product() {
    }

    public Product(String name, int availability) {
        this.Name = name;
        this.Availability = availability;
    }

    @Override
    public String toString() {
        return String.format(
                "Prodict[id=%d, Name='%s', Availabilty='%d']",
                id, Name, Availability);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getAvailability() {
        return Availability;
    }
}