package com.tech.challenge.zonaAzul.ticket.pagamento.model.entity;

import com.tech.challenge.zonaAzul.util.enums.StatusPagamento;
import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    private StatusPagamento statusPagamento;
    private TipoPagamento formaPagamento;

}
