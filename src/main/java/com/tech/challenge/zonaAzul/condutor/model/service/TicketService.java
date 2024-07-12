package com.tech.challenge.zonaAzul.condutor.model.service;

import com.tech.challenge.zonaAzul.condutor.dto.TicketRecord;
import com.tech.challenge.zonaAzul.condutor.dto.UsuarioRecordDTO;
import com.tech.challenge.zonaAzul.condutor.form.TicketForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Condutor;
import com.tech.challenge.zonaAzul.condutor.model.entity.Ticket;
import com.tech.challenge.zonaAzul.condutor.model.repository.CondutorRepository;
import com.tech.challenge.zonaAzul.condutor.model.repository.TicketRepository;
import com.tech.challenge.zonaAzul.util.exception.DatabaseException;
import com.tech.challenge.zonaAzul.util.exception.NoSuchRecordException;
import com.tech.challenge.zonaAzul.util.exception.ValidationRegisterTicketException;
import com.tech.challenge.zonaAzul.util.mappers.TicketMappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TicketService {

    private static final Logger log = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    private TicketRepository repository;

    @Autowired
    private CondutorRepository condutorRepository;

    public List<TicketRecord> listarTodosTickets() {
        List<Ticket> ticketList = repository.findAll();
        validarTicketsConsultados(ticketList);
        return TicketMappers.ticketMapperEntitiesToDTOs(ticketList);
    }

    public List<TicketRecord> obterTicketsPorCondutor(String cpfCondutor) {
        List<Ticket> ticketList = repository.findAllByCondutor_Cpf(cpfCondutor);
        validarTicketsConsultados(ticketList);
        return TicketMappers.ticketMapperEntitiesToDTOs(ticketList);
    }

    private void validarTicketsConsultados(List<Ticket> ticketsList) {
        if (Objects.isNull(ticketsList) || ticketsList.isEmpty()) {
            throw new NoSuchRecordException("Não há nenhum ticket adquirido no sistema");
        }
    }

    public TicketRecord obterPorId(String id) {
        Ticket ticketEntidade = repository.findById(id)
                .orElseThrow(() -> new NoSuchRecordException("Não há ticket cadastrado no sistema com o id informado."));
        return TicketMappers.ticketMapperDTO(ticketEntidade);
    }

    public TicketRecord salvar(TicketForm ticketForm) {
        Ticket ticketEntidade = TicketMappers.ticketMapper(ticketForm);
        ticketEntidade.setDataHoraEntrada(new Date());

        Condutor condutor = condutorRepository.findByCpf(ticketForm.getCpfCondutor());
        validarCadastroCondutor(condutor, false);
        associarCondutorAoTicket(ticketEntidade, condutor);

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

        Condutor condutor = condutorRepository.findByCpf(ticketForm.getCpfCondutor());
        validarCadastroCondutor(condutor, true);
        if (!ticketForm.getCpfCondutor().equals(condutor.getCpf())) {
            throw new ValidationRegisterTicketException("Não é possível atualizar um ticket com condutor diferente do informado na hora da compra do mesmo");
        }
        associarCondutorAoTicket(ticketEntidade, condutor);

        try {
            return TicketMappers.ticketMapperDTO(repository.save(ticketEntidade));
        } catch (Exception e) {
            throw new DatabaseException("Não foi possível realizar e edição. ", e);
        }
    }

    private void associarCondutorAoTicket(Ticket ticketEntidade, Condutor condutor) {
        ticketEntidade.setCondutor(new UsuarioRecordDTO(condutor.getNome(), condutor.getCpf()));
        condutor.getTickets().add(ticketEntidade);
        condutorRepository.save(condutor);
    }

    private void validarCadastroCondutor(Condutor condutor, boolean ticketPersistido) {
        if (condutor == null) {
            if (ticketPersistido) {
                throw new ValidationRegisterTicketException("Não é possível registrar a compra do ticket, pois não existe condutor registrado no sistema com o CPF informado");
            }
            throw new ValidationRegisterTicketException("Não é atualizar registrar o ticket, pois não existe condutor registrado no sistema com o CPF informado");
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
