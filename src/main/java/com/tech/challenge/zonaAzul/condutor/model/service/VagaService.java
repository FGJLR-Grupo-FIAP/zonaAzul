package com.tech.challenge.zonaAzul.condutor.model.service;


import com.tech.challenge.zonaAzul.condutor.dto.VagaDto;
import com.tech.challenge.zonaAzul.condutor.model.entity.Vaga;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VagaService {


    @Autowired
    private VagaRepository repository;

    @Transactional
    public List<VagaDto> vagas() {
        List<Vaga> list = repository.findAll();
        return list.stream().map(x -> new VagaDto(x)).collect(Collectors.toList());

    }

    @Transactional
    public VagaDto encontrarVagas(Long id) {
        Optional<Vaga> obj = repository.findById(id);
        Vaga entity = obj.get();
        return new VagaDto(entity);

    }

    @Transactional
    public VagaDto inserirVaga(VagaDto dto) {
        Vaga entity = new Vaga();
        entity.setLocal(dto.getLocal());
        entity.setStatusVaga(dto.getStatusVaga());
        return new VagaDto(entity);
    }



    @Transactional
    public VagaDto atualizar(Long id, VagaDto dto) {
        Vaga entity = repository.findById(id, dto);
        entity.setLocal(dto.getLocal());
        entity.setStatusVaga(dto.getStatusVaga());
        entity = repository.save(entity);
        return new VagaDto(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);

    }
}
