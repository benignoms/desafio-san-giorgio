package br.com.desafio.payment.model;

import br.com.desafio.payment.model.enumeration.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentItemModel {

    private String id;
    private BigDecimal amount;
    private BigDecimal amountPaid;
    private PaymentType paymentType;

    public PaymentType getPaymentType() {
        if(amount.compareTo(amountPaid) > 0) {
            return PaymentType.OVERPAYMENT;
        }
        if(amount.compareTo(amountPaid) < 0) {
            return PaymentType.PARTIAL;
        }
        if(amount.compareTo(amountPaid) == 0) {
            return PaymentType.TOTAL;
        }
        return PaymentType.UNPAID;
    }
}
