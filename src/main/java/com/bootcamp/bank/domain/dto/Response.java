package com.bootcamp.bank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Response {

    private String codigo;
    private String mensaje;

    public Response() {

    }

    public Response(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
