package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Pagamento;

public class pagamentoDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Pagamento pagamento) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pagamento);
		em.getTransaction().commit();
		em.close();

	}
}
