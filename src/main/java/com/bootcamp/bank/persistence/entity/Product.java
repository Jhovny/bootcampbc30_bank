package com.bootcamp.bank.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="product")
public class Product {

    @Id
    private String id;
    private String type_account;
    private String category;
    private String number_account;

    private String[] holders;
    private String[] authorized_signers;

}
