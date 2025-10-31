package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Fatura;

public class FaturaDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Fatura fatura) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(fatura);
		em.getTransaction().commit();
		em.close();

	}
}
