package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Comodidades;


public class ComodidadesDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Comodidades comodidades) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(comodidades);
		em.getTransaction().commit();
		em.close();

	}
}
