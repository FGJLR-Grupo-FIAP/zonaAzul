package com.tech.challenge.zonaAzul.condutor.model.repository;

import com.tech.challenge.zonaAzul.condutor.model.entity.Veiculo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, String> {




}
