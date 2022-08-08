package com.bootcamp.bank.persistence;

import com.bootcamp.bank.persistence.crud.IClientRepository;
import com.bootcamp.bank.persistence.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ClientRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientRepository.class);

    @Autowired
    private IClientRepository clientRepository;



    public Flux<Client> getAll(){

        Flux<Client> clientes = clientRepository.findAll()
                .doOnNext(client -> log.info(client.getId_client()));

        return clientes;
    }




}
