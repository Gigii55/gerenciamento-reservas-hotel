package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Reserva;

public class ReservaDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Reserva reserva) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(reserva);
		em.getTransaction().commit();
		em.close();

	}
}