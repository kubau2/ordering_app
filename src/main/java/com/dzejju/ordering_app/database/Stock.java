package com.dzejju.ordering_app.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

    @Id
    private Long id;
    private int availability;

    protected Stock() {
    }


    public Stock(Long id, int availability) {
        this.id = id;
        this.availability = availability;
    }


    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

}