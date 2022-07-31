package com.ozkaraca.ticketproject.repository;

import com.ozkaraca.ticketproject.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
}
