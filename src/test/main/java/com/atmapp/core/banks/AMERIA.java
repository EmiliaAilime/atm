package com.atmapp.core.banks;

public class AMERIA extends Bank {
    private static AMERIA ameria;

    public AMERIA() {

    }

    public static AMERIA getAmeriaInstance() {
        if (ameria == null) {
            ameria = new AMERIA();
        }
        return ameria;
    }
}
