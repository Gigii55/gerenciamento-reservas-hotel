package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;


public class PessoaDAO {
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");
	
	public void inserirPessoa (String nome, String cpf, String telefone, String email) {
		
		
		Pessoa pessoa = new Pessoa ();
		
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		pessoa.setTelefone(telefone);
		pessoa.setEmail(email);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		em.close();
		
		
	
	}
		

	
}
