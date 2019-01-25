package com.atmapp.core.enums;


import com.atmapp.core.banks.AMERIA;
import com.atmapp.core.banks.Bank;
import com.atmapp.core.banks.HSBC;

public enum IssuerBank {
    AMERIA {
        private Bank bank;

        @Override
        public Bank getInstance() {

            if (bank == null) {
                bank = new AMERIA();
                return bank;
            }

            return bank;
        }
    },
    HSBC {

        private Bank bank;

        @Override
        public Bank getInstance() {
            if (bank == null) {
                bank = new HSBC();
                return bank;
            }

            return bank;
        }
    };

    public abstract Bank getInstance();


}
