package br.com.desafio.payment.repository;

import br.com.desafio.payment.model.PaymentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPaymentRepository extends MongoRepository<PaymentModel, String> {
}
