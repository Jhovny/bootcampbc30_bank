package com.bootcamp.bank.domain.dto.purchase;


import com.bootcamp.bank.domain.dto.Request;


public class PurchaseConsumptionCreditRequest extends Request {

    private String numberCard;
    private double amount;

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
