package com.dzejju.ordering_app.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerID) {
        super("Customer with ID: " + String.valueOf(customerID) + " not found.");
    }
}
