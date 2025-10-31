package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Atendente;


public class AtendenteDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Atendente atendente) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(atendente);
		em.getTransaction().commit();
		em.close();

	}
}
