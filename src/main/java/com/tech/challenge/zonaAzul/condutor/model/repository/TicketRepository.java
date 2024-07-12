package com.tech.challenge.zonaAzul.condutor.model.repository;

import com.tech.challenge.zonaAzul.condutor.model.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

}
