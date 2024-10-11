package br.com.desafio.seller.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("seller")
public class SellerModel {

    @Id
    private String objectId;
    @Indexed
    private String cpf;
    private String nome;
}
