package br.com.desafio.payment.messaging;

import br.com.desafio.payment.dto.PaymentDto;
import br.com.desafio.payment.model.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequiredArgsConstructor
public abstract class ProcessPayment {

    protected RabbitTemplate rabbitTemplate;

    public abstract void process(PaymentModel payment);

    protected void processPaymentLogic(PaymentModel payment, String queue) {
        rabbitTemplate.convertAndSend(queue, PaymentDto.fromModel(payment));
    }
}
