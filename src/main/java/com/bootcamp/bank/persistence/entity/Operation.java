package com.bootcamp.bank.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Operation {
    private String idOperation;
    private String date;
    private String amount;

    private String type;

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
