package com.tech.challenge.zonaAzul.condutor.dto;

import java.math.BigDecimal;
import java.util.Date;

public record TicketRecord(String id,
                           Date dataHoraEntrada,
                           Date dataHoraSaida,
                           BigDecimal valor,
                           boolean periodoEstacionamentoFixo) {
}
