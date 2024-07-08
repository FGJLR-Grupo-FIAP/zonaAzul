package com.tech.challenge.zonaAzul.condutor.model.service;

import com.tech.challenge.zonaAzul.condutor.dto.CondutorRecod;
import com.tech.challenge.zonaAzul.condutor.form.CondutorForm;
import com.tech.challenge.zonaAzul.condutor.model.CondutorRepository;
import com.tech.challenge.zonaAzul.condutor.model.entity.Condutor;
import com.tech.challenge.zonaAzul.util.mappers.CondutorMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository repository;


    public CondutorRecod salvar(CondutorForm condutorForm){
        return criarOuAtualizar(condutorForm, true);

    }

    private CondutorRecod criarOuAtualizar(CondutorForm condutorForm, boolean novo) {
        CondutorRecod condutorRecod = null;

        Condutor condutor = CondutorMappers.condutorMapper(condutorForm);
        Condutor condutorExistente = repository.findByCpf(condutorForm.getCpf());

        if (condutorExistente == null && Boolean.TRUE.equals(novo)){
            condutorRecod = persistirCondutor(condutor);
            return  condutorRecod;
        }else if(condutorExistente != null && Boolean.FALSE.equals(novo)){
            condutor.setId(condutorExistente.getId());
            condutor.setDataHoraCadastro(condutorExistente.getDataHoraCadastro());
            condutor.setDataHoraAtualizacao(new Date());
            condutorRecod = persistirCondutor(condutor);
        }
        return condutorRecod;
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

    public CondutorRecod condutor(String cpf) {
        Condutor condutor = repository.findByCpf(cpf);
        CondutorRecod condutorRecod = CondutorMappers.condutorMapperDTO(condutor);
        return condutorRecod;
    }

    public CondutorRecod editarDadosCondutor(CondutorForm condutorForm) {
        return criarOuAtualizar(condutorForm, false);
    }

    public void deletarCondutor(String cpf) {
        Condutor condutorExistente = repository.findByCpf(cpf);

        if (condutorExistente != null){
            repository.deleteByCpf(cpf);
        }
    }
}
