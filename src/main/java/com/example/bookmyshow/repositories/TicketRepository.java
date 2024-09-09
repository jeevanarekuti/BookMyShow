package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    //If ticket already present in DB it will update params otherwise it will update.
    Ticket save(Ticket ticket);
}
