package br.com.desafio.seller.usecase;

import br.com.desafio.seller.exception.SellerNotFoundException;
import br.com.desafio.seller.model.SellerModel;
import br.com.desafio.seller.repository.ISellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckSellerUseCase implements ICheckSellerUseCase {

    private final ISellerRepository sellerRepository;

    @Override
    public SellerModel getSellerByCpf(String cpf) {

        return sellerRepository.findByCpf(cpf)
                .orElseThrow(() -> new SellerNotFoundException(cpf));
    }
}
