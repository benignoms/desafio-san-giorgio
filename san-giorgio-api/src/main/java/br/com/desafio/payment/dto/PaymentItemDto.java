package br.com.desafio.payment.dto;

import br.com.desafio.payment.model.PaymentItemModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PaymentItemDto(
        @JsonProperty("id")
        String id,
        @JsonProperty("amount")
        BigDecimal amount,
        @JsonProperty("amount_paid")
        BigDecimal amountPaid,
        @JsonProperty("type")
        String type) {

        public static PaymentItemDto fromModel(PaymentItemModel paymentItemModel) {

                return PaymentItemDto.builder()
                        .id(paymentItemModel.getId())
                        .amount(paymentItemModel.getAmount())
                        .amountPaid(paymentItemModel.getAmountPaid())
                        .type(paymentItemModel.getPaymentType().name())
                        .build();
        }

        public PaymentItemModel toModel() {

                return PaymentItemModel.builder()
                        .id(id)
                        .amountPaid(amountPaid)
                        .amount(amount)
                        .build();
        }
}
