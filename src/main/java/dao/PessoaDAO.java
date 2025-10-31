package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class PessoaDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirNovaPessoa (Pessoa pessoa) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		em.close();

	}
}
