package com.tech.challenge.zonaAzul.condutor.controller;

import com.tech.challenge.zonaAzul.condutor.dto.CondutorRecod;
import com.tech.challenge.zonaAzul.condutor.form.CondutorForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Condutor;
import com.tech.challenge.zonaAzul.condutor.model.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/condutor")
public class CondutorController {

    @Autowired
    private CondutorService service;


    @PostMapping("/salvar")
    public Condutor save(@RequestBody CondutorForm condutor){
        service.salvar(condutor);
        return null;
    }
}
