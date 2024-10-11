package br.com.desafio.payment.messaging;

import br.com.desafio.payment.dto.PaymentDto;
import br.com.desafio.payment.model.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TotalProcessPayment extends ProcessPayment {

    @Value("${queue.total}")
    private String totalPaymentsQueue;

    public void process(PaymentModel payment) {
        processPaymentLogic(payment, totalPaymentsQueue);
    }
}
