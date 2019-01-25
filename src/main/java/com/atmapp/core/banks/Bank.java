package com.atmapp.core.banks;


import com.atmapp.core.employee.Account;
import com.atmapp.core.managers.BankManger;

import java.util.Map;
import java.util.logging.Logger;

public abstract class Bank implements BankManger {


    private Map<String, Account> accounts;
    private boolean flag = false;
    Logger logger = Logger.getLogger("MyLog");


    protected Bank() {

    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public synchronized void getMoney(int amount, String id) {
        if (checkAmount(amount, id)) {
            logger.info("get money");
            System.out.println("You have " + ((this.getAccounts().get(id).getAmount()) - amount) + "$");
            this.getAccounts().get(id).setAmount((this.getAccounts().get(id).getAmount()) - amount);
        }
    }

    @Override
    public synchronized boolean checkAmount(int amount, String id) {
        if (!(this.getAccounts().get(id).getAmount() > amount)) {

            logger.info("You don't have much money");
            return false;
        }
        flag = true;
        return true;
    }

    public synchronized boolean allWork() {
        return flag;
    }


}
