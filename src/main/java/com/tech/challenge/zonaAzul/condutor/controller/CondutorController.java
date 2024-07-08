package com.tech.challenge.zonaAzul.condutor.controller;

import com.tech.challenge.zonaAzul.condutor.dto.CondutorRecod;
import com.tech.challenge.zonaAzul.condutor.form.CondutorForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Condutor;
import com.tech.challenge.zonaAzul.condutor.model.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("api/v1/condutor")
public class CondutorController {

    @Autowired
    private CondutorService service;


    @PostMapping("/salvar")
    public ResponseEntity<CondutorRecod> salvar(@RequestBody CondutorForm condutor){
        ResponseEntity response = null;

        try {
            CondutorRecod condutorRecod = service.salvar(condutor);
            response = ResponseEntity.status(HttpStatus.CREATED).body(condutorRecod);
        }catch (Exception e){
            return null;
        }
        return response;
    }

    @GetMapping("/condutores")
    public ResponseEntity<List<CondutorRecod>> condutores(){
        ResponseEntity response = null;

        try {
            List<CondutorRecod> condutorRecod = service.condutores();
            response = ResponseEntity.status(HttpStatus.OK).body(condutorRecod);
        }catch (Exception e){
            return null;
        }
        return response;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CondutorRecod> condutor(@PathVariable String cpf){
        ResponseEntity response = null;

        try {
            CondutorRecod condutor = service.condutor(cpf);
            response = ResponseEntity.status(HttpStatus.OK).body(condutor);
        }catch (Exception e){
            return null;
        }

        return response;
    }

    @PutMapping("/editar")
    public ResponseEntity<CondutorRecod> editarCondutor(@RequestBody CondutorForm condutorForm){
        ResponseEntity response = null;

        try {
            CondutorRecod condutor = service.editarDadosCondutor(condutorForm);
        }catch (Exception e){
            return null;
        }
        return response;
    }

    @DeleteMapping("deletar={cpf}")
    public ResponseEntity deletarCondutor(@PathVariable String cpf){
        service.deletarCondutor(cpf);
        return ResponseEntity.ok("Cadastro deletado com sucesso!");
    }
}
