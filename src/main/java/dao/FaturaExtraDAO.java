package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.FaturaExtra;

public class FaturaExtraDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void faturaExtra (double valor, String descricao) {
		
		FaturaExtra faturaExtra = new FaturaExtra();
		faturaExtra.setValor(valor);
		faturaExtra.setDescricao(descricao);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(faturaExtra);
		em.getTransaction().commit();
		em.close();
		
		
	}
}
