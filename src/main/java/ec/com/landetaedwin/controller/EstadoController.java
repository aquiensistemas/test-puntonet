package ec.com.landetaedwin.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.landetaedwin.model.Estado;
import ec.com.landetaedwin.service.EstadoService;

@Named
@ViewScoped
public class EstadoController {

	public List<Estado> estadoList;
	public Integer estado;

	@Inject
	private EstadoService service;

	@PostConstruct
	private void init() {
		estadoList = service.all();
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
