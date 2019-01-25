package com.atmapp.core.banks;

public class HSBC extends Bank {

    static HSBC HSBC;


    public HSBC() {
    }

    public static HSBC getHSBCInstance() {
        if (HSBC == null) {
            HSBC = new HSBC();
        }
        return HSBC;
    }
}

