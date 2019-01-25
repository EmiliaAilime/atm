package com.atmapp.core.managerImplement;


import com.atmapp.core.atm.ATM;
import com.atmapp.core.managers.ATMManager;

import java.util.logging.Logger;

public class ATMManagerImplement implements ATMManager {

    Logger logger = Logger.getLogger("ATMService");

    public ATMManagerImplement() {
    }

    @Override
    public synchronized boolean checkMoney(int amount, ATM ATM) {
        if (!(ATM.getBalance() > amount)) {

            logger.info("ATM doesn't work");

            return false;
        }
        return true;
    }

    @Override
    public synchronized void reduceBalance(int amount, ATM ATM) {
        if (checkMoney(amount, ATM)) {
            logger.info("redue Banlance");
            ATM.setBalance(ATM.getBalance() - amount);
        }

    }
}
