package com.bootcamp.bank.domain.service;

import com.bootcamp.bank.agent.client.ApiWebClient;
import com.bootcamp.bank.domain.dto.client.ClientApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class ClientApiService {



    @Autowired
    private ApiWebClient apiClient;


    public ClientApiResponse getClient (String idClient) {


        ClientApiResponse clientResponse = (ClientApiResponse) apiClient.getClientById(idClient);


        return clientResponse;

    }




}
