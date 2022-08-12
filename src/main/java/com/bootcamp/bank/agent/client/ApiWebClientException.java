package com.bootcamp.bank.agent.client;

import org.springframework.web.reactive.function.client.WebClientException;

public class ApiWebClientException extends WebClientException {
    public ApiWebClientException(String msg) {
        super(msg);
    }

    public ApiWebClientException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
