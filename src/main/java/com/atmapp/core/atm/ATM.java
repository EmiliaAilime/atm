package com.atmapp.core.atm;


import com.atmapp.core.banks.Bank;
import com.atmapp.core.exceptions.ATMWorkErrorException;
import com.atmapp.core.exceptions.LessMoneyException;
import com.atmapp.core.managerImplement.ATMManagerImplement;
import com.atmapp.core.managerImplement.BankManagerImplement;

public class ATM {
    private int balance = 10000;
    private Bank bank;
    private BankManagerImplement bankManagerImplement;
    private ATMManagerImplement ATMManagerImplement;

    public ATM() {


    }


    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankManagerImplement getBankManagerImplement() {
        return bankManagerImplement;
    }

    public void setBankManagerImplement(BankManagerImplement bankManagerImplement) {
        this.bankManagerImplement = bankManagerImplement;
    }

    public ATMManagerImplement getATMManagerImplement() {
        return ATMManagerImplement;
    }

    public void setATMManagerImplement(ATMManagerImplement ATMManagerImplement) {
        this.ATMManagerImplement = ATMManagerImplement;
    }

    public synchronized void withDraw(int amount, String cardNumber) throws LessMoneyException, ATMWorkErrorException {
        if (ATMManagerImplement.checkMoney(amount, this)) {
            if (bank.checkAmount(amount, cardNumber)) {
                bankManagerImplement.BankManagerMethod();
                ATMManagerImplement.reduceBalance(amount, this);
                System.out.println("Get your " + amount + "$");
            } else {
                throw new LessMoneyException();
            }
        } else {
            throw new ATMWorkErrorException();
        }

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
