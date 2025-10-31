	package model;
	
	import javax.persistence.Entity;
	import javax.persistence.Table;
	
	@Entity
	@Table (name = "atendente")

	public class Atendente extends Pessoa{
	
		private Idioma idioma;

		public Idioma getIdioma() {
			return idioma;
		}

		public void setIdioma(Idioma idioma) {
			this.idioma = idioma;
		}
	
	}
