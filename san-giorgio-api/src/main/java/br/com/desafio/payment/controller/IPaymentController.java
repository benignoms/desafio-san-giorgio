package br.com.desafio.payment.controller;

import br.com.desafio.payment.dto.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

@Tag(name = "Payment Controller", description = "Gerenciamento dos pagamentos")
public interface IPaymentController {

    @Operation(summary = "Confirma pagamentos", description = "Confirma os pagamentos informados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Confirmação de pagamentos enviada com sucesso",
                    content = @Content(schema = @Schema(implementation = PaymentDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    ResponseEntity<PaymentDto> confirmPayment(PaymentDto paymentDto);

    @Operation(summary = "Consultar status pagamento", description = "Consulta o status de pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta o status de pagamento com sucesso",
                    content = @Content(schema = @Schema(implementation = PaymentDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    ResponseEntity<PaymentDto> checkPaymentStatus(Integer paymentId);
}
