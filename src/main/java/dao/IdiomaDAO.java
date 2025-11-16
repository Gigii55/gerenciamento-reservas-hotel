package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Atendente;
import model.Idioma;



public class IdiomaDAO {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void adicionarIdioma (String nome) {
	
			
			Idioma idioma = new Idioma();
			
			idioma.setNome(nome);
			
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(idioma);
			em.getTransaction().commit();
			em.close();
			
			
	}
}
