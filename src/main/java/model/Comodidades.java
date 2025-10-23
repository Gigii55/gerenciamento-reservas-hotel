package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "comodidades")	
public class Comodidades {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100, name ="tipo_comodidade")
	private TipoComodidades tipo;
	
	@Column(nullable = false, length = 100, name ="nome_comodidade")
	private String nome;
	
	
	public TipoComodidades getTipo() {
		return tipo;
	}
	public void setTipo(TipoComodidades tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
}
