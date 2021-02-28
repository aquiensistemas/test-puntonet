package ec.com.landetaedwin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prioridad")
public class Prioridad {

	@Id
	@Column(name = "IDPRIORIDAD")
	private Integer idPrioridad;

	@Column(name = "DESCRIPCIONPRIORIDAD")
	private String descripcionPrioridad;

	public int getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getDescripcionPrioridad() {
		return descripcionPrioridad;
	}

	public void setDescripcionPrioridad(String descripcionPrioridad) {
		this.descripcionPrioridad = descripcionPrioridad;
	}

}
