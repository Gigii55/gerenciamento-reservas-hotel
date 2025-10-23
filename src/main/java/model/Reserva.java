package model;

import java.sql.Date;
import java.time.LocalDateTime;

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
	
	@Column(nullable = false, length = 100, unique = true, name ="data_reserva")
	private Date dataReserva;
	
	LocalDateTime agora = LocalDateTime.now();
	
	@Column(name = "data_checkin", nullable = false)
	private LocalDateTime dataCheckin;
	
	@Column(name = "data_checkout", nullable = false)
	private LocalDateTime dataCheckout;
	
	@Column(name = "data_checkout", nullable = false)
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


	public LocalDateTime getDataCheckin() {
		return dataCheckin;
	}


	public void setDataCheckin(LocalDateTime dataCheckin) {
		this.dataCheckin = dataCheckin;
	}


	public LocalDateTime getDataCheckout() {
		return dataCheckout;
	}


	public void setDataCheckout(LocalDateTime dataCheckout) {
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
	
	
	
	
}


