package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "idioma")
public class Idioma {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(nullable = false, length = 100, name ="nome_idioma")
	private String nome;

	public long getId() {
		return id;
	}
	
	
	
}
