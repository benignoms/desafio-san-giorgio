package br.com.desafio.payment.usecase;


import br.com.desafio.payment.dto.PaymentDto;
import br.com.desafio.payment.model.PaymentModel;

public interface IConfirmPaymentUseCase {

    PaymentModel confirm(PaymentDto paymentDto);
}
