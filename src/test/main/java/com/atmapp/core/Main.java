package com.atmapp.core;


import com.atmapp.core.atm.ATM;
import com.atmapp.core.card.Card;
import com.atmapp.core.employee.Account;
import com.atmapp.core.xmlParser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        //XmlParser
        List<Card> cardList = new Parser().xmlParser();
        ATM atm = new ATM();
        final HelperforThread helperforThread = new HelperforThread(cardList, atm);

        //AccountMap
        Map<String, Account> accountMap = new HashMap();
        for (int i = 0; i < cardList.size(); i++) {
            accountMap.put(cardList.get(i).getCardnumber(), new Account(cardList.get(i).getCardnumber(), 2000));
        }

        for (int i = 0; i <= 10; i++) {
            final int money = Main.input.nextInt();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    helperforThread.getMoney(money);
                }
            });
            thread.start();
            System.out.println(atm.getBalance());
        }

    }

}

