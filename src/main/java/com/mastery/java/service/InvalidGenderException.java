package com.mastery.java.service;

public class InvalidGenderException extends RuntimeException{
    public InvalidGenderException(String checkGender) {
        super("Invalid gender, Please choose M for man or W for woman " + checkGender);
    }
}
