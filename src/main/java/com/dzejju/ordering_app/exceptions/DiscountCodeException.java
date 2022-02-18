package com.dzejju.ordering_app.exceptions;

public class DiscountCodeException extends RuntimeException {
    public DiscountCodeException() {
        super("Discount code invalid");
    }
}
