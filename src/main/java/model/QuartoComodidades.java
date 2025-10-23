package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "quarto_comodidades")	

public class QuartoComodidades {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne 
	@JoinColumn (name = "id_quarto")
	private Quarto quarto;
	
	@ManyToOne 
	@JoinColumn (name = "id_comodidades")
	private Comodidades comodidades;

	
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Comodidades getComodidades() {
		return comodidades;
	}

	public void setComodidades(Comodidades comodidades) {
		this.comodidades = comodidades;
	}

	public long getId() {
		return id;
	}


}
