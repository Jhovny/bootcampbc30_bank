package com.bootcamp.bank.domain.dto.account;

public class Client {

    private String idClient;
    private String typeClient;

    public Client() {
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }
}
