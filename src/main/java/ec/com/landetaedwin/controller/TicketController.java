package ec.com.landetaedwin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import ec.com.landetaedwin.model.Cliente;
import ec.com.landetaedwin.model.ElementosRed;
import ec.com.landetaedwin.model.Estado;
import ec.com.landetaedwin.model.Prioridad;
import ec.com.landetaedwin.model.Ticket;
import ec.com.landetaedwin.service.ClienteService;
import ec.com.landetaedwin.service.ElementoService;
import ec.com.landetaedwin.service.EstadoService;
import ec.com.landetaedwin.service.PrioridadService;
import ec.com.landetaedwin.service.TicketService;
import ec.com.landetaedwin.service.mail.EmailBody;
import ec.com.landetaedwin.service.mail.EmailPort;

@Named
@ViewScoped
public class TicketController {

	public List<Ticket> tickets = null;
	public List<ElementosRed> elementoList;
	public List<Prioridad> prioridadList;
	public List<Estado> estadoList;

	private Ticket ticket = new Ticket();
	private Integer elemetoTicket;
	private Integer prioridadTicket;

	private Integer estado;
	private Integer estadoFilter;

	@Inject
	private TicketService service;

	@Inject
	private ElementoService elementoService;

	@Inject
	private PrioridadService prioridadService;

	@Inject
	private ClienteService clienteService;

	@Inject
	private EstadoService estadoService;

	@Autowired
	private EmailPort emailPort;

	@PostConstruct
	private void init() {
		tickets = new ArrayList<>();
		tickets = service.all();
		estadoList = estadoService.all();
	}

	public void onTicketCreate() {
		ticket = new Ticket();
		elemetoTicket = 0;
		prioridadTicket = 0;
		prioridadList = prioridadService.all();
		elementoList = elementoService.all();
	}

	public void create() {
		Ticket t = new Ticket();
		t.setDescripcionTicket(ticket.getDescripcionTicket());
		t.setIdPrioridad(prioridadTicket);
		t.setIdElemento(elemetoTicket);
		t.setIdEstado(1);
		t.setIdOperador(1);
		t.setFechaCreacion(new Date());

		service.create(t);

		TaskMail(elemetoTicket);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content"));

		tickets = service.all();
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlg').hide();");
		ticket = new Ticket();
		elemetoTicket = 0;
		prioridadTicket = 0;
	}

	public void delete(Integer ticket) {
		System.out.println("deleteRecordInDB() : Ticket Id: " + ticket);
		service.delete(ticket);
		tickets = service.all();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Ticked deleted!", null));
	}

	public void edit(Integer id) {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlgEdit').show();");

		System.out.println("editRecordInDB() : Ticket Id: " + id);
		prioridadList = prioridadService.all();
		elementoList = elementoService.all();

		Ticket t = service.getOne(id);
		ticket = new Ticket();

		elemetoTicket = t.getIdElemento();
		prioridadTicket = t.getIdPrioridad();
		ticket.setDescripcionTicket(t.getDescripcionTicket());
		ticket.setIdTicket(t.getIdTicket());

	}

	public void changeStatus(Integer id) {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlgEditStatus').show();");
		Ticket t = service.getOne(id);
		ticket = new Ticket();
		estado = t.getIdEstado();
		ticket.setIdTicket(t.getIdTicket());
	}

	public void update() {
		Ticket t = service.getOne(ticket.getIdTicket());
		t.setDescripcionTicket(ticket.getDescripcionTicket());
		t.setIdPrioridad(prioridadTicket);
		t.setIdElemento(elemetoTicket);
		t.setFechaActualizacion(new Date());
		service.update(t);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content"));

		tickets = service.all();
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlgEdit').hide();");
		ticket = new Ticket();
		elemetoTicket = 0;
		prioridadTicket = 0;
	}

	public void change() {
		Ticket t = service.getOne(ticket.getIdTicket());
		t.setIdEstado(estado);
		t.setFechaActualizacion(new Date());
		service.update(t);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content"));

		tickets = service.all();
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlgEditStatus').hide();");
		ticket = new Ticket();
		elemetoTicket = 0;
		prioridadTicket = 0;
		estado = 0;
	}

	public void TaskMail(Integer idElemento) {
		List<Cliente> clientes = clienteService.getClientByIdElemento(idElemento);

		if (!clientes.isEmpty()) {
			for (Cliente cliente : clientes) {
				System.out.println(cliente.getEmailCliente());
				EmailBody eb = new EmailBody();
				eb.setSubject("INFORME TECNICO");
				eb.setContent("Estimado " + cliente.getNombreCliente()
						+ " existe un problema técnico disculpe las molestias ocacionadas");
				eb.setEmail(cliente.getEmailCliente());
				emailPort.sendEmail(eb);
			}
		}

	}

	public void updateTicket() {
		System.out.println("New value: " + estado);

		FacesContext.getCurrentInstance().renderResponse();
	}

	public void updateTable(ValueChangeEvent event) {

		if (event.getNewValue() != null) {
			tickets = new ArrayList<>();
			List<Ticket> tickets = service.all();

			for (Ticket elm : tickets) {
				if (elm.getIdEstado().equals(event.getNewValue())) {
					tickets.add(elm);
				}
			}
		}

		FacesContext.getCurrentInstance().renderResponse();
	}

	public List<Ticket> getAll() {
		return tickets;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<ElementosRed> getElementoList() {
		return elementoList;
	}

	public void setElementoList(List<ElementosRed> elementoList) {
		this.elementoList = elementoList;
	}

	public List<Prioridad> getPrioridadList() {
		return prioridadList;
	}

	public void setPrioridadList(List<Prioridad> prioridadList) {
		this.prioridadList = prioridadList;
	}

	public Integer getElemetoTicket() {
		return elemetoTicket;
	}

	public void setElemetoTicket(Integer elemetoTicket) {
		this.elemetoTicket = elemetoTicket;
	}

	public Integer getPrioridadTicket() {
		return prioridadTicket;
	}

	public void setPrioridadTicket(Integer prioridadTicket) {
		this.prioridadTicket = prioridadTicket;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}

	public Integer getEstadoFilter() {
		return estadoFilter;
	}

	public void setEstadoFilter(Integer estadoFilter) {
		this.estadoFilter = estadoFilter;
	}

}
