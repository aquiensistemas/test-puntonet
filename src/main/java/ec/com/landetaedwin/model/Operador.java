package ec.com.landetaedwin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operador")
public class Operador {

	@Id
	@Column(name = "IDOPERADOR")
	private Integer idOperador;

	@Column(name = "NOMBREOPERADOR")
	private String nombreOperador;

	@Column(name = "APELLIDOOPERADOR")
	private String apellidoOperador;

	@Column(name = "ESTADO")
	private boolean estado;

	public int getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	public String getNombreOperador() {
		return nombreOperador;
	}

	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}

	public String getApellidoOperador() {
		return apellidoOperador;
	}

	public void setApellidoOperador(String apellidoOperador) {
		this.apellidoOperador = apellidoOperador;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
