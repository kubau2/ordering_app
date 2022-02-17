package com.dzejju.ordering_app.exceptions;

public class ProductNotFoundException  extends RuntimeException {
    public ProductNotFoundException(Long productId) {
        super("Product with ID: " + String.valueOf(productId) + " not found.");
    }
}
