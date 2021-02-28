package ec.com.landetaedwin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTICKET")
	private Integer idTicket;

	@Column(name = "DESCRIPCIONTICKET")
	private String descripcionTicket;

	@Column(name = "FECHACREACION")
	private Date fechaCreacion;

	@Column(name = "FECHAACTUALIZACION")
	private Date fechaActualizacion;

	@Column(name = "IDELEMENTO")
	private Integer idElemento;

	@Column(name = "IDOPERADOR")
	private Integer idOperador;

	@Column(name = "IDESTADO")
	private Integer idEstado;

	@Column(name = "IDPRIORIDAD")
	private Integer idPrioridad;

	@ManyToOne
	@JoinColumn(name = "IDPRIORIDAD", referencedColumnName = "IDPRIORIDAD", insertable = false, updatable = false)
	private Prioridad prioridad;

	@ManyToOne
	@JoinColumn(name = "IDESTADO", referencedColumnName = "IDESTADO", insertable = false, updatable = false)
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "IDOPERADOR", referencedColumnName = "IDOPERADOR", insertable = false, updatable = false)
	private Operador operador;

	@ManyToOne
	@JoinColumn(name = "IDELEMENTO", referencedColumnName = "IDELEMENTO", insertable = false, updatable = false)
	private ElementosRed elemento;

	public Integer getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public String getDescripcionTicket() {
		return descripcionTicket;
	}

	public void setDescripcionTicket(String descripcionTicket) {
		this.descripcionTicket = descripcionTicket;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Integer getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(Integer idElemento) {
		this.idElemento = idElemento;
	}

	public Integer getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(Integer idOperador) {
		this.idOperador = idOperador;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(Integer idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public ElementosRed getElemento() {
		return elemento;
	}

	public void setElemento(ElementosRed elemento) {
		this.elemento = elemento;
	}

}
