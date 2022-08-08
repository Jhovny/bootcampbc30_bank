package com.bootcamp.bank.persistence;

import com.bootcamp.bank.persistence.crud.IProductRepository;
import com.bootcamp.bank.persistence.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductRepository {

    private static final Logger log = LoggerFactory.getLogger(ProductRepository.class);

    @Autowired
    private IProductRepository dao;



    public Flux<Product> getAll(){

        Flux<Product> productos = dao.findAll()
                .doOnNext(prod -> log.info(prod.getId()));

        return productos;
    }




}
