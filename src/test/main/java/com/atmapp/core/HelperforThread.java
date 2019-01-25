package com.atmapp.core;


import com.atmapp.core.atm.ATM;
import com.atmapp.core.banks.Bank;
import com.atmapp.core.card.Card;
import com.atmapp.core.employee.Account;
import com.atmapp.core.exceptions.ATMWorkErrorException;
import com.atmapp.core.exceptions.LessMoneyException;
import com.atmapp.core.managerImplement.ATMManagerImplement;
import com.atmapp.core.managerImplement.BankManagerImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperforThread {


    private List<Card> cardList;
    private ATM atm;


    public HelperforThread(List<Card> cardList, ATM atm) {
        this.cardList = cardList;
        this.atm = atm;
    }


    public synchronized void getMoney(int money) {
        int index = (int) (Math.random() * cardList.size());
        //RandomCard
        Card thiscard = cardList.get(index);
        //RandomCardNumber
        String thiscardnumber = thiscard.getCardnumber();

        //AccountMap
        Map<String, Account> accountMap = new HashMap();
        for (int i = 0; i < cardList.size(); i++) {
            accountMap.put(cardList.get(i).getCardnumber(), new Account(cardList.get(i).getCardnumber(), 2000));
        }

        //BankInstance
        Bank thiscardBank = thiscard.getIssuerbank();
        thiscardBank.setAccounts(accountMap);


        System.out.println("valid card");
        System.out.print("Take money from atm($): ");

        atm.setBankManagerImplement(new BankManagerImplement(thiscardBank, money, thiscardnumber));
        atm.setBank(thiscardBank);
        atm.setATMManagerImplement(new ATMManagerImplement());

        try {
            atm.withDraw(money, thiscardnumber);
        } catch (LessMoneyException e) {
            e.printStackTrace();
        } catch (ATMWorkErrorException e) {
            e.printStackTrace();
        }

        System.out.println("ATM balance " + atm.getBalance());

    }


}
