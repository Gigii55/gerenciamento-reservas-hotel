package dao;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Fatura;
import model.StatusPagamento;


public class FaturaDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void adicionarFatura (double valorTotal, double desconto, StatusPagamento statusPagamento, Date dataFechamento) {
		
		Fatura fatura = new Fatura ();
		fatura.setValorTotal(valorTotal);
		fatura.setDesconto(desconto);
		fatura.setStatusPagamento(statusPagamento);
		fatura.setDataFechamento(new Date());
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(fatura);
		em.getTransaction().commit();
		em.close();
		
	}
}
