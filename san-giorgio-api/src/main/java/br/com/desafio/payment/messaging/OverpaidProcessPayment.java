package br.com.desafio.payment.messaging;

import br.com.desafio.payment.model.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OverpaidProcessPayment extends ProcessPayment {

    @Value("${queue.overpaid}")
    private String overpaidPaymentsQueue;

    public void process(PaymentModel payment) {
        processPaymentLogic(payment, overpaidPaymentsQueue);
    }
}
