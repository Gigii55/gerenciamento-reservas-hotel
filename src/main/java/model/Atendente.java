	package model;
	
	import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.Table;
	
	@Entity
	@Table (name = "atendente")

	public class Atendente extends Pessoa{
	
		@Column(nullable = false)
		private String senha;

		public String getSenha() { 
			return senha;
			}
		
		public void setSenha(String senha) { 
			this.senha = senha;
			}
	}
