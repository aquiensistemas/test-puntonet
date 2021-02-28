package ec.com.landetaedwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.landetaedwin.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}