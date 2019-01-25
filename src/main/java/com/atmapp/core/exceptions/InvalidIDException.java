package com.atmapp.core.exceptions;

public class InvalidIDException extends MyException {
    public InvalidIDException() {
        System.err.println("Invalid card");
    }
}