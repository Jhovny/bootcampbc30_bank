package com.bootcamp.bank.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {


    @GetMapping("/prueba1")
    public ResponseEntity<String> prueba1(){

        return new ResponseEntity<>("1", HttpStatus.OK ) ;
    }

}
