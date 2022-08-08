package com.bootcamp.bank.persistence.crud;

import com.bootcamp.bank.persistence.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {

}
