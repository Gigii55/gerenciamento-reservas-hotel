package model;

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
@Table (name = "reserva")	

public class Reserva {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne 
	@JoinColumn (name = "id_atendente")
	private Atendente atendente;
	
	@ManyToOne
    @JoinColumn (name = "id_hospede")
	private Hospede hospede;
	
	@ManyToOne
    @JoinColumn(name = "id_quarto", nullable = false)
    private Quarto quarto;
	
	@Column(nullable = false, length = 100, unique = true, name ="data_reserva")
	private Date dataReserva;
	
	@Column(name = "data_checkin", nullable = false)
	private Date dataCheckin;
	
	@Column(name = "data_checkout", nullable = false)
	private Date dataCheckout;
	
	@Column(name = "status", nullable = false)
	private Status status;


	public Atendente getAtendente() {
		return atendente;
	}


	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}


	public Date getDataReserva() {
		return dataReserva;
	}


	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}


	public Date getDataCheckin() {
		return dataCheckin;
	}


	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}


	public Date getDataCheckout() {
		return dataCheckout;
	}


	public void setDataCheckout(Date dataCheckout) {
		this.dataCheckout = dataCheckout;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public long getId() {
		return id;
	}
	
	
	public Quarto getQuarto() {
		return quarto;
	}


	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Hospede getHospede() {
		return hospede;
	}
}


