package ec.com.landetaedwin.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.Ticket;
import ec.com.landetaedwin.repository.TicketRepository;

@Named
public class TicketService {

	@Inject
	private TicketRepository repository;

	public void create(Ticket ticket) {
		repository.save(ticket);
	}

	public void update(Ticket ticket) {
		repository.save(ticket);
	}

	public void delete(Integer ticket) {
		repository.deleteById(ticket);
	}

	public Ticket getOne(Integer ticket) {
		return repository.findById(ticket).get();
	}

	public List<Ticket> all() {
		List<Ticket> tickets = repository.findAll();
		return tickets;
	}

}
