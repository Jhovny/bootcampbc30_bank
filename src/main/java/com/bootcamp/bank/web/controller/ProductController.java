package com.bootcamp.bank.web.controller;


import com.bootcamp.bank.domain.dto.account.AccountOpenRequest;
import com.bootcamp.bank.domain.dto.account.AccountOpenResponse;
import com.bootcamp.bank.domain.dto.purchase.PayCreditRequest;
import com.bootcamp.bank.domain.dto.purchase.PayCreditResponse;
import com.bootcamp.bank.domain.dto.purchase.PurchaseConsumptionCreditRequest;
import com.bootcamp.bank.domain.dto.purchase.PurchaseConsumptionCreditResponse;
import com.bootcamp.bank.persistence.ProductRepository;
import com.bootcamp.bank.persistence.entity.Operation;
import com.bootcamp.bank.persistence.entity.Product;
import com.bootcamp.bank.util.ConstanteGenerales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public   Flux<Product>  getAll(){


        Flux<Product> clientes =productRepository.getAll();

        return clientes ;
    }

    @PostMapping("/account-open")
    public Flux<ResponseEntity<AccountOpenResponse>> payCredit(@RequestBody AccountOpenRequest request) {

        AccountOpenResponse response = new AccountOpenResponse();

        Flux<Product> productPasivos = productRepository.getProductPasivo(request.getClient().getIdClient());


        if (request.getClient().getTypeClient().equals(ConstanteGenerales.TYPE_CLIENT_EMPRESA)) {

            if (request.getProduct().getTypeAccount().equals(ConstanteGenerales.TYPE_PRODUCTO_CUENTA_AHORRO) ||
                    request.getProduct().getTypeAccount().equals(ConstanteGenerales.TYPE_PRODUCTO_CUENTA_PAZLOFIJO)) {

                response.setMensaje("No esta permitido registrar cuenta de ahorro o cuenta plazo fijo");
                response.setCodigo(ConstanteGenerales.RESPUESTA_API_ALERTA);

                return Flux.just(new ResponseEntity<>(response, HttpStatus.OK));
            } else {
                Product productNew = productRepository.AccountOpen(request);

                AccountOpenResponse response2 = new AccountOpenResponse(ConstanteGenerales.RESPUESTA_API_OK, "Registrado con exito", productNew.getId());

                return Flux.just(new ResponseEntity<>(response2, HttpStatus.OK));

            }


        } else {

            List<Product> produList= null;


            Flux<Product> responsess= productPasivos.filter(p ->
                             p.getTypeAccount().equals(ConstanteGenerales.TYPE_PRODUCTO_CUENTA_CUENTACORRIENTE)
                                    || p.getTypeAccount().equals(ConstanteGenerales.TYPE_PRODUCTO_CUENTA_PAZLOFIJO)

                    );

            try{
                produList=responsess.collectList().block();

            }catch (Exception err){
                produList= new ArrayList<>();

            }


            if(produList.isEmpty()){

                Product productNew = productRepository.AccountOpen(request);

                response.setMensaje("Registrado con exito");
                response.setId(productNew.getId());
                response.setCodigo(ConstanteGenerales.RESPUESTA_API_ALERTA);

            }else{
                response.setMensaje("Solo puede registrar una cuenta corriente o plazo fijo");
                response.setCodigo(ConstanteGenerales.RESPUESTA_API_ALERTA);
            }



            return Flux.just(new ResponseEntity<>(response, HttpStatus.OK));
        }


    }


    @PostMapping("/pay-credit")
    public PayCreditResponse payCredit(@RequestBody PayCreditRequest request) {

        PayCreditResponse response = new PayCreditResponse();
        Optional<Product> producSeach = productRepository.getByNumberCard(request.getProduct()
                        .getNumberCard())
                .blockOptional();

        if (producSeach.isEmpty()) {
            response.setMensaje("No existe el numero de tarjeta");
            response.setCodigo(ConstanteGenerales.RESPUESTA_API_ALERTA);

            return response;
        }

        Product productEn = productRepository.getByNumberCard(request.getProduct()
                .getNumberCard()).block();

        productEn.setPayments(request.getProduct().getPayments());
        productEn.setAmountPay(request.getProduct().getAmountPay());
        Mono<Product> productSave = productRepository.PayCredit(productEn);

        response.setMensaje("Se pago la cuenta satisfactoriamente");
        response.setCodigo(ConstanteGenerales.RESPUESTA_API_OK);

        return response;

    }

    @PostMapping("/purchase-credit")
    public PurchaseConsumptionCreditResponse payCredit(@RequestBody PurchaseConsumptionCreditRequest request) {

        PurchaseConsumptionCreditResponse response = new PurchaseConsumptionCreditResponse();
        Optional<Product> producSeach = productRepository.getByNumberCard(request.getNumberCard())
                .blockOptional();

        if (producSeach.isEmpty()) {
            response.setMensaje("No existe el numero de tarjeta");
            response.setCodigo(ConstanteGenerales.RESPUESTA_API_ALERTA);
            return response;
        }

        Product productEn = productRepository.getByNumberCard(request.getNumberCard()
        ).block();

        productEn.setNumberCard(request.getNumberCard());
        productEn.setAvailableBalance(productEn.getAvailableBalance() - request.getAmount());
        Mono<Product> productSave = productRepository.PayCredit(productEn);

        response.setMensaje("Se cargo el consumo a su tarjeta");
        response.setCodigo(ConstanteGenerales.RESPUESTA_API_OK);

        return response;

    }


    @PutMapping("/withdrawal/{id}/{amount}")
    public Mono<Product> Withdrawal(@PathVariable String id, @PathVariable float amount){
        Flux<Product> productos = productRepository.getByNumberAccount(id);
        Product producto = productos.blockFirst();
        if(producto.getBalance() > amount){
            producto.setBalance(producto.getBalance() - amount);
            Operation operation = new Operation();
            operation.setIdOperation(id + amount);
            operation.setDate(String.valueOf(LocalDate.now()));
            operation.setAmount("-"+String.valueOf(amount));
            operation.setType("Withdrawal");
            producto.getBankOperations().add(operation);
        }
        return productRepository.updateBalance(producto);
    }

    @PutMapping("/deposit/{id}/{amount}")
    public Mono<Product> Deposit(@PathVariable String id, @PathVariable float amount){
        Flux<Product> productos = productRepository.getByNumberAccount(id);
        Product producto = productos.blockFirst();
        producto.setBalance(producto.getBalance() + amount);
        Operation operation = new Operation();
        operation.setIdOperation(id + amount);
        operation.setDate(String.valueOf(LocalDate.now()));
        operation.setAmount("+"+String.valueOf(amount));
        operation.setType("Deposit");
        producto.getBankOperations().add(operation);
        return productRepository.updateBalance(producto);
    }

    @GetMapping("/checkBalance/{id}")
    public float CheckBalance(@PathVariable String id){
        Flux<Product> productos = productRepository.getByNumberAccount(id);
        Product producto = productos.blockFirst();
        return producto.getBalance();
    }

    @GetMapping("/checkOperations/{id}")
    public List<Operation> CheckOperations(@PathVariable String id){
        Flux<Product> productos = productRepository.getByNumberAccount(id);
        Product producto = productos.blockFirst();
        return producto.getBankOperations();
    }

}
