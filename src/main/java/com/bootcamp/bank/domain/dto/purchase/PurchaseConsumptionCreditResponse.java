package com.bootcamp.bank.domain.dto.purchase;


import com.bootcamp.bank.domain.dto.Response;
import com.bootcamp.bank.domain.dto.account.Client;
import com.bootcamp.bank.persistence.entity.Product;


public class PurchaseConsumptionCreditResponse  extends Response {



    private Product product;
    private Client client;

    public Product getProduct() {
        return product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
