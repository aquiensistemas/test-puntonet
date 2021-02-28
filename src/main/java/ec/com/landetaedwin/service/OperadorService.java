package ec.com.landetaedwin.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.Operador;
import ec.com.landetaedwin.repository.OperadorRepository;

@Named
public class OperadorService {

	@Inject
	private OperadorRepository repository;

	public List<Operador> all() {
		List<Operador> list = repository.findAll();
		return list;
	}

}
