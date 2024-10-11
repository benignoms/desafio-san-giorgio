package br.com.desafio.payment.controller;


import br.com.desafio.payment.dto.PaymentDto;
import br.com.desafio.payment.model.PaymentModel;
import br.com.desafio.payment.usecase.IConfirmPaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController implements IPaymentController {

    private final IConfirmPaymentUseCase confirmPaymentUseCase;

    @Override
    @PostMapping
    public ResponseEntity<PaymentDto> confirmPayment(PaymentDto paymentDto) {
        PaymentModel paymentModel = confirmPaymentUseCase.confirm(paymentDto);
        return ResponseEntity.status(HttpStatus.OK).body(PaymentDto.fromModel(paymentModel));
    }

    @Override
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto> checkPaymentStatus(@PathVariable Integer paymentId) {

        return ResponseEntity.status(HttpStatus.OK).body(PaymentDto.builder().build());
    }
}
