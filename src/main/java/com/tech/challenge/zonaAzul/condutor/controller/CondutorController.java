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
            CondutorRecod condutorRecod = service.salvar(condutor, true);
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
}
