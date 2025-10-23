package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "fatura_extra")
public class FaturaExtra {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100, name ="valor")
	private double valor; 
	
	@Column(nullable = false, length = 250, name ="descricao")
	private String descricao;
	
}
