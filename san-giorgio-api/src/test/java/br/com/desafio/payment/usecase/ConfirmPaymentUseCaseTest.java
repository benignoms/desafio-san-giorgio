package br.com.desafio.payment.usecase;

import br.com.desafio.payment.dto.PaymentDto;
import br.com.desafio.payment.messaging.PartialProcessPayment;
import br.com.desafio.payment.model.PaymentItemModel;
import br.com.desafio.payment.model.PaymentModel;
import br.com.desafio.payment.model.enumeration.PaymentStatus;
import br.com.desafio.payment.repository.IPaymentRepository;
import br.com.desafio.seller.model.SellerModel;
import br.com.desafio.seller.usecase.CheckSellerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ConfirmPaymentUseCaseTest {

    @Mock
    private IPaymentRepository paymentRepository;

    @Mock
    private CheckSellerUseCase checkSellerUseCase;

    @Mock
    private PartialProcessPayment partialProcessPaymentUseCase;

    @InjectMocks
    private ConfirmPaymentUseCase confirmPaymentUseCase;


    @Test
    void test_confirmPaymentUseCase() {

        String sellerCpf = "76173414074";

        SellerModel seller = SellerModel.builder()
                .cpf(sellerCpf)
                .nome("Paulo de Tarso")
                .build();

        PaymentItemModel paymentItemModel = PaymentItemModel.builder()
                .id(UUID.randomUUID().toString())
                .amount(BigDecimal.TEN)
                .amountPaid(BigDecimal.TEN)
                .build();

        Optional<PaymentModel> paymentModelOptional = Optional.of(PaymentModel.builder()
                .id(UUID.randomUUID().toString())
                .status(PaymentStatus.PENDING)
                .seller(seller)
                .paymentItems(Collections.singletonList(paymentItemModel))
                .build());

        PaymentDto paymentDto = PaymentDto.fromModel(paymentModelOptional.get());

        Mockito.when(paymentRepository.findById(Mockito.anyString())).thenReturn(paymentModelOptional);
        Mockito.when(checkSellerUseCase.getSellerByCpf(Mockito.anyString())).thenReturn(seller);

        PaymentModel payment = confirmPaymentUseCase.confirm(paymentDto);

        Assertions.assertEquals(payment.getStatus(), PaymentStatus.RECEIVED);
    }

}
