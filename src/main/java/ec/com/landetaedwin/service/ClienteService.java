package ec.com.landetaedwin.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.Cliente;
import ec.com.landetaedwin.repository.ClienteRepository;

@Named
public class ClienteService {

	@Inject
	private ClienteRepository repository;

	public List<Cliente> all() {
		List<Cliente> list = repository.findAll();
		return list;
	}

	public List<Cliente> getClientByIdElemento(Integer id) {
		List<Cliente> list = repository.findByIdElemento(id);
		return list;
	}

}
