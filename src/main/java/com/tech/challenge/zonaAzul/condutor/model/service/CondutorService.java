package com.tech.challenge.zonaAzul.condutor.model.service;

import com.tech.challenge.zonaAzul.condutor.dto.CondutorRecod;
import com.tech.challenge.zonaAzul.condutor.form.CondutorForm;
import com.tech.challenge.zonaAzul.condutor.model.CondutorRepository;
import com.tech.challenge.zonaAzul.condutor.model.entity.Condutor;
import com.tech.challenge.zonaAzul.util.mappers.CondutorMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository repository;


    public CondutorRecod salvar(CondutorForm condutorForm, boolean criar){
        return criarOuAtualizar(condutorForm, criar);

    }

    private CondutorRecod criarOuAtualizar(CondutorForm condutorForm, boolean novo) {
        CondutorRecod condutorRecod = null;

        Condutor condutor = CondutorMappers.condutorMapper(condutorForm);
        Condutor condutorExistente = repository.findByCpf(condutorForm.getCpf());

        if (condutorExistente == null && Boolean.TRUE.equals(novo)){
            condutorRecod = persistirCondutor(condutor);
            return  condutorRecod;
        }
        return null;
    }

    private CondutorRecod persistirCondutor(Condutor condutor) {
        Condutor novoCondutor = repository.save(condutor);
        CondutorRecod condutorRecod = CondutorMappers.condutorMapperDTO(novoCondutor);
        return condutorRecod;
    }

    public List<CondutorRecod> condutores() {
        List<Condutor> condutorList = null;
        List<CondutorRecod> condutorRecodList = null;

        condutorList = repository.findAll();
        condutorRecodList = CondutorMappers.condutorMapper(condutorList);

        return condutorRecodList;
    }
}
