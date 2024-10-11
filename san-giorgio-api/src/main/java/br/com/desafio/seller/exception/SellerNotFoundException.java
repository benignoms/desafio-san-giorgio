package br.com.desafio.seller.exception;

public class SellerNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Seller with CPF %s not found";

    public SellerNotFoundException(String code) {
        super(MESSAGE.formatted(code));
    }
}
