package com.bootcamp.bank.persistence.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection="Product")
public class Product {

    @Id
    private String id;
    private String typeAccount;
    private String category;
    private String numberAccount;
    private String numberCard;
    private String idClient;
    private String[] holders;
    private String[] authorizedSigners;
    private Double availableBalance;
    private Double amountPay;
    private List<Operation> bankOperations;
    private float balance;

    public List<Operation> getBankOperations() {
        return bankOperations;
    }

    public void setBankOperations(List<Operation> bankOperations) {
        this.bankOperations = bankOperations;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private List<Payment> payments;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String[] getHolders() {
        return holders;
    }

    public void setHolders(String[] holders) {
        this.holders = holders;
    }

    public String[] getAuthorizedSigners() {
        return authorizedSigners;
    }

    public void setAuthorizedSigners(String[] authorizedSigners) {
        this.authorizedSigners = authorizedSigners;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Double getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(Double amountPay) {
        this.amountPay = amountPay;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
