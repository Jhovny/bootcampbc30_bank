package com.bootcamp.bank.persistence.crud;

import com.bootcamp.bank.persistence.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
    Mono<Product> findByNumberCard(String numbreCard);
}
