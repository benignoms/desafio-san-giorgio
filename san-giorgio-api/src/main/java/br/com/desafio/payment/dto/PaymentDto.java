package br.com.desafio.payment.dto;

import br.com.desafio.payment.model.PaymentItemModel;
import br.com.desafio.payment.model.PaymentModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;

import java.util.List;

@Builder
public record PaymentDto(
        @JsonProperty("id")
        String id,
        @JsonProperty("seller_cpf")
        String sellerCpf,
        @JsonProperty("status")
        String status,
        @JsonProperty("payment_items")
        List<PaymentItemDto> payments) {

        public static PaymentDto fromModel(PaymentModel paymentModel) {

                List<PaymentItemDto> payments = paymentModel.getPaymentItems().stream()
                        .map(PaymentItemDto::fromModel).toList();
                return PaymentDto.builder()
                        .id(paymentModel.getId())
                        .sellerCpf(paymentModel.getSeller().getCpf())
                        .status(paymentModel.getStatus().name())
                        .payments(payments)
                        .build();
        }
}
