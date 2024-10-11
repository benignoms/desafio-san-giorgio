package br.com.desafio.payment.messaging;

import br.com.desafio.payment.dto.PaymentDto;
import br.com.desafio.payment.model.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PartialProcessPayment extends ProcessPayment {

    @Value("${queue.partial}")
    private String partialPaymentsQueue;

    public void process(PaymentModel paymentDto) {
        processPaymentLogic(paymentDto, partialPaymentsQueue);
    }
}
