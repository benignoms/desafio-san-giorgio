package br.com.desafio.payment.model;

import br.com.desafio.payment.model.enumeration.PaymentStatus;
import br.com.desafio.seller.model.SellerModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document("payment")
public class PaymentModel {

    @Id
    private String id;
    private SellerModel seller;
    private PaymentStatus status;
    @Builder.Default
    private List<PaymentItemModel> paymentItems = new ArrayList<>();

}
