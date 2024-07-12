package com.tech.challenge.zonaAzul.condutor.model.repository;

import com.tech.challenge.zonaAzul.condutor.model.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findAllByCondutor_Cpf(String cpfCondutor);

}
