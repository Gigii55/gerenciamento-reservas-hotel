package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Comodidades;
import model.TipoComodidades;



public class ComodidadesDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirComodidade (TipoComodidades tipo, String nome ) {
		
		Comodidades comodidades = new Comodidades ();
		comodidades.setNome(nome);
		comodidades.setTipo(tipo);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(comodidades);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
