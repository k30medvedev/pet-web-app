package com.mastery.java.exception;

import java.time.LocalDate;

public class PersonAlreadyInUseException extends RuntimeException {
    public PersonAlreadyInUseException(String firstName, String lastName, LocalDate birthDay) {
        super("Such person already exists:" + firstName + " " + lastName + " " + birthDay);
    }
}
