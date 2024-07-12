package com.tech.challenge.zonaAzul.condutor.model.service;

import com.tech.challenge.zonaAzul.condutor.dto.TicketRecord;
import com.tech.challenge.zonaAzul.condutor.form.TicketForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Ticket;
import com.tech.challenge.zonaAzul.condutor.model.repository.TicketRepository;
import com.tech.challenge.zonaAzul.util.exception.DatabaseException;
import com.tech.challenge.zonaAzul.util.exception.NoSuchRecordException;
import com.tech.challenge.zonaAzul.util.mappers.TicketMappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    private static final Logger log = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    private TicketRepository repository;

    public List<TicketRecord> listarTodosTickets() {
        List<Ticket> ticketList = repository.findAll();
        if (ticketList.isEmpty()) {
            throw new NoSuchRecordException("Não há nenhum ticket adquirido no sistema");
        }
        return TicketMappers.ticketMapperEntitiesToDTOs(ticketList);
    }

    public TicketRecord obterPorId(String id) {
        Ticket ticketEntidade = repository.findById(id)
                .orElseThrow(() -> new NoSuchRecordException("Não há ticket cadastrado no sistema com o id informado."));
        return TicketMappers.ticketMapperDTO(ticketEntidade);
    }

    public TicketRecord salvar(TicketForm ticketForm) {
        Ticket ticketEntidade = TicketMappers.ticketMapper(ticketForm);
        ticketEntidade.setDataHoraEntrada(new Date());
        try {
            return TicketMappers.ticketMapperDTO(repository.insert(ticketEntidade));
        } catch (Exception e) {
            throw new DatabaseException("Não foi possível persistir o ticket. ", e);
        }
    }

    public TicketRecord editar(TicketForm ticketForm, String id) {
        Ticket ticketEntidade = repository.findById(id)
                .orElseThrow(() -> new NoSuchRecordException("Não há ticket cadastrado no sistema com o id informado."));
        ticketEntidade.setDataHoraSaida(ticketForm.getDataHoraSaida());
        ticketEntidade.setValor(ticketForm.getValor());
        try {
            return TicketMappers.ticketMapperDTO(repository.save(ticketEntidade));
        } catch (Exception e) {
            throw new DatabaseException("Não foi possível realizar e edição. ", e);
        }
    }

    public void deletar(String id) {
        obterPorId(id);
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new DatabaseException("Não foi possível realizar e exclusão. ", e);
        }
    }

}
