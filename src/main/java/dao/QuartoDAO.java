package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Quarto;


public class QuartoDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Quarto quarto) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();
		em.close();

	}
	
}
