package com.bootcamp.bank.domain.dto.account;

import com.bootcamp.bank.domain.dto.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AccountOpenResponse extends Response {

    private String Id;

    public String getId() {
        return Id;
    }




    public AccountOpenResponse(String codigo, String mensaje, String id) {
        super(codigo, mensaje);
        Id = id;
    }
    public AccountOpenResponse(String codigo, String mensaje) {
        super(codigo, mensaje);

    }

    public AccountOpenResponse() {
        super();

    }
    public void setId(String id) {
        Id = id;
    }
}
