package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Idioma;


public class IdiomaDAO {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Idioma idioma) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(idioma);
		em.getTransaction().commit();
		em.close();

	}
}
