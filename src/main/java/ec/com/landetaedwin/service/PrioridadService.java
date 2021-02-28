package ec.com.landetaedwin.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.Prioridad;
import ec.com.landetaedwin.repository.PrioridadRepository;

@Named
public class PrioridadService {

	@Inject
	private PrioridadRepository repository;

	public List<Prioridad> all() {
		List<Prioridad> list = repository.findAll();
		return list;
	}

}
