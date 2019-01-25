package com.atmapp.core.managerImplement;


import com.atmapp.core.banks.Bank;

public class BankManagerImplement {
    private Bank bank;
    private int amount;
    private String ID;


    public BankManagerImplement(Bank bank, int amount, String ID) {
        this.bank = bank;
        this.amount = amount;
        this.ID = ID;
    }

    public synchronized void BankManagerMethod() {
        if (bank.allWork()) {
            bank.getMoney(amount, ID);
        }
    }
}
