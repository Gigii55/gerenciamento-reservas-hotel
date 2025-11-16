package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Atendente;



public class AtendenteDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirAtendente (String nome, String cpf, String telefone, String email) {
		
		Atendente atendente = new Atendente();
		
		atendente.setNome(nome);
		atendente.setCpf(cpf);
		atendente.setTelefone(telefone);
		atendente.setEmail(email);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(atendente);
		em.getTransaction().commit();
		em.close();
		
		
	}
}
