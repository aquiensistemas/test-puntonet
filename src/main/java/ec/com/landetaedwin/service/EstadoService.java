package ec.com.landetaedwin.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.Estado;
import ec.com.landetaedwin.repository.EstadoRepository;

@Named
public class EstadoService {

	@Inject
	private EstadoRepository repository;

	public List<Estado> all() {
		List<Estado> estadoList = repository.findAll();
		return estadoList;
	}

}
