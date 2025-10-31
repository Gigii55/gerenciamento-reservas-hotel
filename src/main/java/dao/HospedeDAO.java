package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Hospede;

public class HospedeDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Hospede hospede) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(hospede);
		em.getTransaction().commit();
		em.close();

	}
}
