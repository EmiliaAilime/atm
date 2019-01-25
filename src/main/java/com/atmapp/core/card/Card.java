package com.atmapp.core.card;


import com.atmapp.core.banks.Bank;
import com.atmapp.core.enums.CardBrand;
import com.atmapp.core.enums.Currency;

import java.util.Date;

public class Card {
    private String cardnumber;
    private CardBrand cardBrand;
    private Currency currency;
    private Bank issuerbank;
    private String cardholder;
    private Date expiredate;

    public Card(CardCreater cardCreater) {
        this.cardnumber = cardCreater.cardnumber;
        this.cardBrand = cardCreater.cardBrand;
        this.currency = cardCreater.currency;
        this.issuerbank = cardCreater.issuerbank;
        this.cardholder = cardCreater.cardholder;
        this.expiredate = cardCreater.expiredate;

    }

    public String getCardnumber() {
        return cardnumber;
    }

    public CardBrand getCardBrand() {
        return cardBrand;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Bank getIssuerbank() {
        return issuerbank;
    }

    public String getCardholder() {
        return cardholder;
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public static class CardCreater {
        private String cardnumber;
        private CardBrand cardBrand;
        private Currency currency;
        private Bank issuerbank;
        private String cardholder;
        private Date expiredate;

        public CardCreater setCardnumber(String cardnumber) {

            this.cardnumber = cardnumber;
            return this;

        }

        public CardCreater setCardBrand(CardBrand cardBrand) {
            this.cardBrand = cardBrand;
            return this;
        }

        public CardCreater setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public CardCreater setIssuerbank(Bank issuerbank) {
            this.issuerbank = issuerbank;
            return this;
        }

        public CardCreater setCardholder(String cardholder) {
            this.cardholder = cardholder;
            return this;
        }

        public CardCreater setExpiredate(Date expiredate) {
            this.expiredate = expiredate;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }
}
