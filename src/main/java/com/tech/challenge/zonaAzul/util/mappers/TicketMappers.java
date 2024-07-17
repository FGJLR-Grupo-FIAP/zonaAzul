package com.tech.challenge.zonaAzul.util.mappers;

import com.tech.challenge.zonaAzul.ticket.dto.TicketRecord;
import com.tech.challenge.zonaAzul.ticket.form.TicketForm;
import com.tech.challenge.zonaAzul.ticket.model.entity.Ticket;

import java.util.List;
import java.util.Objects;

public class TicketMappers {

    public static TicketRecord ticketMapperDTO(Ticket ticket) {
        return new TicketRecord(
                ticket.getId(),
                ticket.getDataHoraEntrada(),
                ticket.getDataHoraSaida(),
                ticket.getValor(),
                ticket.isPeriodoEstacionamentoFixo(),
                PagamentoMappers.pagamentoMapperDTO(ticket.getPagamento())
        );
    }

    public static Ticket ticketMapper(TicketForm ticketForm) {
        Ticket ticket = new Ticket();
        ticket.setPeriodoEstacionamentoFixo(ticketForm.getQuantidadeHoras() != null && ticketForm.getQuantidadeHoras() > 0);
        ticket.setPagamento(PagamentoMappers.pagamentoMapper(ticketForm.getPagamento()));
        return ticket;
    }

    public static List<TicketRecord> ticketMapperEntitiesToDTOs(List<Ticket> ticketList) {
        return ticketList
                .stream()
                .map(TicketMappers::ticketMapperDTO)
                .toList();
    }

}
