package com.mastery.java.service;

public class InvalidDigitalException extends RuntimeException {
    public InvalidDigitalException(String firstName) {
        super("Invalid digital " + firstName);
    }
}
