package com.bootcamp.bank.persistence;


import com.bootcamp.bank.domain.dto.account.AccountOpenRequest;
import com.bootcamp.bank.persistence.crud.IProductRepository;
import com.bootcamp.bank.persistence.entity.Product;
import com.bootcamp.bank.util.ConstanteGenerales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRepository {

    private static final Logger log = LoggerFactory.getLogger(ProductRepository.class);

    @Autowired
    private IProductRepository dao;



    public Flux<Product> getAll(){

        Flux<Product> productos = dao.findAll();

        return productos;
    }

    public Flux<Product> getProductPasivo(String idClient) {


            Flux<Product> productsAll = dao.findAll();

          return  productsAll
                    .filter(p ->
                            p.getIdClient().equals(idClient) &&
                                    p.getCategory().equals(ConstanteGenerales.TYPE_PRODUCTO_CATEGORY_PASIVO)
                    ).defaultIfEmpty(  new Product());

    }
    public Flux<Product> getProductActivo(String idClient){
        Flux<Product> productos = dao.findAll();

        return productos
                .filter(p ->
                        p.getIdClient().equals(idClient) &&
                                p.getCategory().equals(ConstanteGenerales.TYPE_PRODUCTO_CATEGORYA_ACTIVO)
                );
    }
    public   Product AccountOpen(AccountOpenRequest request){

        Mono<Product> product = dao.insert(request.getProduct());

        return product.block();
    }


    public Mono<Product> getById(String idProduct){
       return  dao.findById(idProduct);
    }
    public Mono<Product> getByNumberCard(String numberCard){
        return  dao.findByNumberCard(numberCard);
    }
    public Mono<Product> PayCredit(Product product){
            return   dao.save(product);
    }
    public Mono<Product> purchaseConsumptionCredit(Product product){
        return dao.save(product);
    }

    public Flux<Product> getByNumberAccount(String numberAccount) {
        return dao.findAll().filter(request -> request.getNumberAccount().equals(numberAccount));
    }

    public Mono<Product> updateBalance(Product producto){
        return dao.save(producto);
    }

    public Mono<Product> insertOperation(Product producto){
        return dao.save(producto);
    }

}
