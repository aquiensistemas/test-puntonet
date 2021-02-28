package ec.com.landetaedwin.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.Prioridad;
import ec.com.landetaedwin.service.PrioridadService;

@Named
@ViewScoped
public class PrioridadController {

	public List<Prioridad> list;
	public Prioridad prioridad;

	@Inject
	private PrioridadService service;

	@PostConstruct
	private void init() {
		list = service.all();
	}

	public List<Prioridad> getList() {
		return list;
	}

	public void setList(List<Prioridad> list) {
		this.list = list;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

}
