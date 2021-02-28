package ec.com.landetaedwin.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.ElementosRed;
import ec.com.landetaedwin.repository.ElementoRepository;

@Named
public class ElementoService {

	@Inject
	private ElementoRepository repository;

	public List<ElementosRed> all() {
		List<ElementosRed> list = repository.findAll();
		return list;
	}

	public ElementosRed getOne(Integer idElemento) {
		return repository.findById(idElemento).get();

	}

}
