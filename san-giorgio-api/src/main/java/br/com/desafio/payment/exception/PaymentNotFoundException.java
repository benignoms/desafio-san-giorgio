package br.com.desafio.payment.exception;

public class PaymentNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Payment with code %s not found";

    public PaymentNotFoundException(String code) {
        super(MESSAGE.formatted(code));
    }
}
