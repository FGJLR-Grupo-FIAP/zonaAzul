package com.tech.challenge.zonaAzul.ticket.form;

import com.tech.challenge.zonaAzul.ticket.pagamento.form.PagamentoForm;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketForm {

    private Integer quantidadeHoras;

    @NotEmpty(message = "O CPF do condutor é um registro obrigatório para realizar a compra do ticket")
    @Size(min = 11, max = 11, message = "O CPF deve conter {max} caracteres")
    private String cpfCondutor;

    private PagamentoForm pagamento;

}
