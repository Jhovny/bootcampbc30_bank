package com.bootcamp.bank.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="client")
public class Client {

    private String id_client;
    private String type_client;

    private List<Product> Products;

}
