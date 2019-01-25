package com.atmapp.core.exceptions;

public class LessMoneyException extends MyException {
    public LessMoneyException() {
        System.err.println("You don't have much money");
    }
}
