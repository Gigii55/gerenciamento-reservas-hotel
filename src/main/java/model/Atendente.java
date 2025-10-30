	package model;
	
	import javax.persistence.Entity;
	import javax.persistence.Inheritance;
	import javax.persistence.InheritanceType;
	import javax.persistence.Table;
	
	@Entity
	@Table (name = "atendente")
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // talvez usar tablper class
	
	public class Atendente extends Pessoa{
	

	
	}
