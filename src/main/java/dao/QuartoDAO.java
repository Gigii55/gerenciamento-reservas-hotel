package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Quarto;
import model.Status;
import model.Tipo;

public class QuartoDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");
	
	public void adicionarQuarto(int numeroQuarto, Tipo tipoQuarto, Status status, int quantidadeCamas,
										double valorDiaria, String descricao) {
		
		Quarto quarto = new Quarto ();

		quarto.setNumeroQuarto(numeroQuarto);
		quarto.setTipoQuarto(tipoQuarto);
		quarto.setStatus(status);
		quarto.setQuantidadeCamas(quantidadeCamas);
		quarto.setValorDiaria(valorDiaria);
		quarto.setDescricao(descricao);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
