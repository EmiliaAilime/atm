package com.atmapp.core.managers;

public interface BankManger {
    void getMoney(int amount, String id);

    boolean checkAmount(int amount, String id);
}
