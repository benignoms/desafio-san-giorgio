package br.com.desafio.seller.usecase;

import br.com.desafio.seller.model.SellerModel;

public interface ICheckSellerUseCase {

    SellerModel getSellerByCpf(String cpf);
}
