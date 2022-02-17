package com.dzejju.ordering_app.exceptions;

public class NotEnoughProductException extends RuntimeException {
    public NotEnoughProductException(Long productId, Integer available) {
        super("Not enough product with ID: " + String.valueOf(productId) + ". Available: " + String.valueOf(available));
    }
}
