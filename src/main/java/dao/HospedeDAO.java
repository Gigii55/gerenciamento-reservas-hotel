package dao;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Hospede;


public class HospedeDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void adicionarHospede (String nome, String cpf, String telefone, String email, Date dataNascimento) {
		
		Hospede hospede = new Hospede ();
		hospede.setNome(nome);
		hospede.setCpf(cpf);
		hospede.setTelefone(telefone);
		hospede.setEmail(email);
		hospede.setDataNascimento(dataNascimento);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(hospede);
		em.getTransaction().commit();
		em.close();
		
	}
}
