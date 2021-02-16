package com.mastery.java.service;

public class InvalidDigitalException extends Throwable {
    public InvalidDigitalException(String firstName) {
        super("Invalid digital" + firstName);
    }
}
