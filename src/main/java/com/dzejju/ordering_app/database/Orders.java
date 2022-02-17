package com.dzejju.ordering_app.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long customerID;
    private Double value; //do zmiany ten long albo rzutowanie przy ladowaniu danych

    public Orders() {
    }

    public Orders(Long customerID, Double value) {
        this.customerID = customerID;
        this.value = value;
    }



    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }
}