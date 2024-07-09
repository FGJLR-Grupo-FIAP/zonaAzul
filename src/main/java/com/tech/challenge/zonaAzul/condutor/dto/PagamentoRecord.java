package com.tech.challenge.zonaAzul.condutor.dto;

import com.tech.challenge.zonaAzul.util.enums.StatusPagamento;
import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;

public record PagamentoRecord(String id,
                              StatusPagamento statusPagamento,
                              TipoPagamento formaPagamento) {

}
