package com.tech.challenge.zonaAzul.condutor.form;

import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketForm {

    private Date dataHoraSaida;
    private BigDecimal valor;

    @NotEmpty(message = "O CPF do condutor é um registro obrigatório para realizar a compra do ticket")
    @Size(min = 11, max = 11, message = "O CPF deve conter {max} caracteres")
    private String cpfCondutor;

    private PagamentoForm pagamento;

}
