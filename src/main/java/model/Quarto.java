package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "quarto")	

public class Quarto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100, unique = true, name ="numero_quarto")
	private int numeroQuarto;
	
	@Column(nullable = false, length = 100, name ="tipo_quarto")
	private Tipo tipoQuarto;
	
	@Column(nullable = false, length = 100, name ="status_quarto")
	private Status status;
	
	@Column(nullable = false, length = 100, name ="quantidade_camas")
	private int quantidadeCamas;
	
	@Column(nullable = false, length = 100, name ="valor_diaria")
	private double valorDiaria;

	@Column(nullable = false, length = 1000,  name ="descricao")
	private String descricao;
	

	public long getId() {
		return id;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Tipo getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(Tipo tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getQuantidadeCamas() {
		return quantidadeCamas;
	}

	public void setQuantidadeCamas(int quantidadeCamas) {
		this.quantidadeCamas = quantidadeCamas;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	 
	 
	

	
}
