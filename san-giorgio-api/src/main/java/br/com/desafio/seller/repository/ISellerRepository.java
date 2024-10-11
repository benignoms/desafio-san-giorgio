package br.com.desafio.seller.repository;

import br.com.desafio.seller.model.SellerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ISellerRepository extends MongoRepository<SellerModel, String> {

    Optional<SellerModel> findByCpf(String cpf);
}
