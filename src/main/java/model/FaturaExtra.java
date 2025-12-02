package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "fatura_extra")
public class FaturaExtra {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "id_fatura") // Cria a coluna id_fatura na tabela
    private Fatura fatura;


	@Column(nullable = false, length = 100, name ="valor")
	private double valor; 
	
	@Column(nullable = false, length = 250, name ="descricao")
	private String descricao;
	
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}
	
	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}


	
}
