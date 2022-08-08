package com.bootcamp.bank.web.controller;

import com.bootcamp.bank.persistence.ClientRepository;
import com.bootcamp.bank.persistence.ProductRepository;
import com.bootcamp.bank.persistence.entity.Client;
import com.bootcamp.bank.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping()
    public   Flux<Client>  getAll(){


        Flux<Client> clientes =clientRepository.getAll();

        return clientes ;
    }

}
