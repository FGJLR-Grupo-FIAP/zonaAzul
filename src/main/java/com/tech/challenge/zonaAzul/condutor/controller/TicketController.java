package com.tech.challenge.zonaAzul.condutor.controller;

import com.tech.challenge.zonaAzul.condutor.dto.TicketRecord;
import com.tech.challenge.zonaAzul.condutor.form.TicketForm;
import com.tech.challenge.zonaAzul.condutor.model.service.TicketService;
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

    @GetMapping("/{id}")
    public ResponseEntity<TicketRecord> obterPorId(@PathVariable String id) {
        TicketRecord ticketRecord = service.obterPorId(id);
        return ResponseEntity.ok().body(ticketRecord);
    }

    @PostMapping("/salvar")
    public ResponseEntity<TicketRecord> salvar(@RequestBody TicketForm ticketForm) {
        TicketRecord ticketRecord = service.salvar(ticketForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticketRecord.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<TicketRecord> editar(@RequestBody TicketForm ticketForm, @PathVariable String id) {
        TicketRecord ticketRecord = service.editar(ticketForm, id);
        return ResponseEntity.ok().body(ticketRecord);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
