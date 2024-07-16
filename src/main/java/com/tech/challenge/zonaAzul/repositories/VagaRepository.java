package com.tech.challenge.zonaAzul.repositories;


import com.tech.challenge.zonaAzul.condutor.model.entity.Vaga;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VagaRepository extends MongoRepository<Vaga, Long> {

}
