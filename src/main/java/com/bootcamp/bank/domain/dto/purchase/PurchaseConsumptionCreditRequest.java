package com.bootcamp.bank.domain.dto.purchase;


import com.bootcamp.bank.domain.dto.Request;
import com.bootcamp.bank.domain.dto.Response;
import com.bootcamp.bank.domain.dto.account.Client;
import com.bootcamp.bank.persistence.entity.Product;


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
