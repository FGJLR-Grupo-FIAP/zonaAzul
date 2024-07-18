package com.tech.challenge.zonaAzul.veiculo.model.repository;

import com.tech.challenge.zonaAzul.veiculo.model.entity.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, String> {




}
