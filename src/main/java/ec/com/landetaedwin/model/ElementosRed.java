package ec.com.landetaedwin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elementosred")
public class ElementosRed {

	@Id
	@Column(name = "IDELEMENTO")
	private Integer idElemento;

	@Column(name = "DESCRIPCIONELEMENTO")
	private String descripcionElemento;

	@Column(name = "ESTADO")
	private boolean estado;

	public Integer getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(Integer idElemento) {
		this.idElemento = idElemento;
	}

	public String getDescripcionElemento() {
		return descripcionElemento;
	}

	public void setDescripcionElemento(String descripcionElemento) {
		this.descripcionElemento = descripcionElemento;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
