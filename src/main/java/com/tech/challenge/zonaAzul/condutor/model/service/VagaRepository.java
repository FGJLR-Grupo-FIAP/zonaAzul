package com.tech.challenge.zonaAzul.condutor.model.service;


import com.tech.challenge.zonaAzul.condutor.dto.VagaDto;
import com.tech.challenge.zonaAzul.condutor.model.entity.Vaga;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VagaRepository extends MongoRepository<Vaga, Long> {

    Vaga findById(Long id, VagaDto dto);
}
