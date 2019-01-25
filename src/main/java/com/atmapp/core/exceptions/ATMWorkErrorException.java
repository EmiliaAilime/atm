package com.atmapp.core.exceptions;

public class ATMWorkErrorException extends MyException {
    public ATMWorkErrorException() {
        System.err.println("ATM doesn't work");
    }
}
