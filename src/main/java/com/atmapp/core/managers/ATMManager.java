package com.atmapp.core.managers;


import com.atmapp.core.atm.ATM;

public interface ATMManager {
    boolean checkMoney(int amount, ATM ATM);

    void reduceBalance(int amount, ATM ATM);
}
