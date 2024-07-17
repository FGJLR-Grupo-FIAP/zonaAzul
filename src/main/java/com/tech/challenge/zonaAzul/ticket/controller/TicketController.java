package com.tech.challenge.zonaAzul.ticket.controller;

import com.tech.challenge.zonaAzul.ticket.dto.TicketRecord;
import com.tech.challenge.zonaAzul.ticket.form.TicketForm;
import com.tech.challenge.zonaAzul.ticket.model.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping
    public ResponseEntity<List<TicketRecord>> listarTodosTickets() {
        List<TicketRecord> ticketsRecordList = service.listarTodosTickets();
        return ResponseEntity.ok().body(ticketsRecordList);
    }

    @GetMapping("/condutor/{cpf}")
    public ResponseEntity<List<TicketRecord>> obterTicketsPorCondutor(@PathVariable String cpf) {
        List<TicketRecord> ticketRecordList = service.obterTicketsPorCondutor(cpf);
        return ResponseEntity.ok().body(ticketRecordList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketRecord> obterPorId(@PathVariable String id) {
        TicketRecord ticketRecord = service.obterPorId(id);
        return ResponseEntity.ok().body(ticketRecord);
    }

    @PostMapping("/salvar")
    public ResponseEntity<TicketRecord> salvar(@Valid @RequestBody TicketForm ticketForm) {
        TicketRecord ticketRecord = service.salvar(ticketForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticketRecord.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<TicketRecord> editar(@Valid @RequestBody TicketForm ticketForm, @PathVariable String id) {
        TicketRecord ticketRecord = service.editar(ticketForm, id);
        return ResponseEntity.ok().body(ticketRecord);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
