package com.dzejju.ordering_app.exceptions;

public class CustomerDataNotFilledException extends RuntimeException {
    public CustomerDataNotFilledException(Long customerID) {
        super("Customer with ID: " + String.valueOf(customerID) + " doesn't have all necessary data.");
    }

    public CustomerDataNotFilledException() {
        super("Please fill in all data.");
    }
}
