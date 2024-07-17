package com.tech.challenge.zonaAzul.ticket.pagamento.dto;

import com.tech.challenge.zonaAzul.util.enums.StatusPagamento;
import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;

public record PagamentoRecord(StatusPagamento statusPagamento,
                              TipoPagamento formaPagamento) {

}
