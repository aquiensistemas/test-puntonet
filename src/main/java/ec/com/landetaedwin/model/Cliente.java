package ec.com.landetaedwin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@Column(name = "IDCLIENTE")
	private Integer idCliente;

	@Column(name = "IDELEMENTO")
	private Integer idElemento;

	@Column(name = "NOMBRECLIENTE")
	private String nombreCliente;

	@Column(name = "EMAILCLIENTE")
	private String emailCliente;

	@Column(name = "ESTADO")
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "IDELEMENTO", referencedColumnName = "IDELEMENTO", insertable = false, updatable = false)
	private ElementosRed elemento;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(Integer idElemento) {
		this.idElemento = idElemento;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ElementosRed getElemento() {
		return elemento;
	}

	public void setElemento(ElementosRed elemento) {
		this.elemento = elemento;
	}

}
