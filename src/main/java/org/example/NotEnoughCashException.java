package org.example;

public class NotEnoughCashException extends Exception {
    public NotEnoughCashException(String message) {
        super(message);
    }
}