package com.tech.challenge.zonaAzul.condutor.controller;

import com.tech.challenge.zonaAzul.condutor.dto.VagaDto;
import com.tech.challenge.zonaAzul.condutor.model.entity.Vaga;
import com.tech.challenge.zonaAzul.condutor.model.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/vaga")
public class VagaController {

    @Autowired
    private VagaService service;


    @GetMapping
    public ResponseEntity<List<VagaDto>> vagas() {
        List<VagaDto> list = service.vagas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VagaDto> encontrarVagas(@PathVariable Long id) {
        VagaDto dto = service.encontrarVagas(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<VagaDto> inserirVaga(@RequestBody VagaDto dto) {
        dto = service.inserirVaga(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return  ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<VagaDto> editarVaga(@PathVariable Long id, @RequestBody VagaDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<VagaDto> deletarVaga(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
