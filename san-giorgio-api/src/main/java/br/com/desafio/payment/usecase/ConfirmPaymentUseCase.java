package br.com.desafio.payment.usecase;

import br.com.desafio.payment.dto.PaymentDto;
import br.com.desafio.payment.exception.PaymentNotFoundException;
import br.com.desafio.payment.model.PaymentModel;
import br.com.desafio.payment.model.enumeration.PaymentStatus;
import br.com.desafio.payment.repository.IPaymentRepository;
import br.com.desafio.payment.messaging.PartialProcessPayment;
import br.com.desafio.seller.usecase.ICheckSellerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConfirmPaymentUseCase implements IConfirmPaymentUseCase {

    private final IPaymentRepository paymentRepository;
    private final ICheckSellerUseCase checkSellerUseCase;
    private final PartialProcessPayment partialProcessPaymentUseCase;

    @Override
    public PaymentModel confirm(PaymentDto paymentDto) {

        checkSellerUseCase.getSellerByCpf(paymentDto.sellerCpf());
        PaymentModel payment = paymentRepository.findById(paymentDto.id())
                .orElseThrow(() -> new PaymentNotFoundException(paymentDto.id()));
        payment.setStatus(PaymentStatus.RECEIVED);
        paymentRepository.save(payment);
        partialProcessPaymentUseCase.process(payment);

        return payment;
    }
}
