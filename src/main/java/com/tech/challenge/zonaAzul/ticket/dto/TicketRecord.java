package com.tech.challenge.zonaAzul.ticket.dto;

import com.tech.challenge.zonaAzul.ticket.pagamento.dto.PagamentoRecord;

import java.math.BigDecimal;
import java.util.Date;

public record TicketRecord(String id,
                           Date dataHoraEntrada,
                           Date dataHoraSaida,
                           BigDecimal valor,
                           boolean periodoEstacionamentoFixo,
                           PagamentoRecord pagamento) {
}
