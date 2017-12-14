package com.example.peter.findr_practice_app.models;

import com.example.peter.findr_practice_app.models.merchant.Merchant;

/**
 * Created by peter on 12/14/17.
 */

public class Base {

    private int findrCredits;
    private int findrPoints;
    private Merchant merchant;

    public int getFindrCredits() {
        return findrCredits;
    }

    public void setFindrCredits(int findrCredits) {
        this.findrCredits = findrCredits;
    }

    public int getFindrPoints() {
        return findrPoints;
    }

    public void setFindrPoints(int findrPoints) {
        this.findrPoints = findrPoints;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
