package ec.com.landetaedwin.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.ElementosRed;
import ec.com.landetaedwin.service.ElementoService;

@Named
@ViewScoped
public class ElementoController {

	public List<ElementosRed> list;
	public ElementosRed elementoRed;

	@Inject
	private ElementoService service;

	@PostConstruct
	private void init() {
		list = service.all();
	}

	public List<ElementosRed> getList() {
		return list;
	}

	public void setList(List<ElementosRed> list) {
		this.list = list;
	}

	public ElementosRed getElementoRed() {
		return elementoRed;
	}

	public void setElementoRed(ElementosRed elementoRed) {
		this.elementoRed = elementoRed;
	}

}
