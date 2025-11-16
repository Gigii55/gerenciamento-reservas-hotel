package model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table (name = "hospede")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Hospede extends Pessoa{

	@Column(nullable = false, length = 100, name ="data_nascimento")
	private Date dataNascimento;
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
