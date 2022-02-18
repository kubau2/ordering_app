package com.dzejju.ordering_app.exceptions;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException() {
        super("There are no items in the cart");
    }
}
