package dao;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Hospede;
import model.Pagamento;
import model.StatusPagamento;
import model.TipoPagamento;


public class PagamentoDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	public void inserirPagamento(Hospede idHospede, StatusPagamento Statuspagamento, Date dataPagamento, TipoPagamento tipoPagamento) {
		
		EntityManager em = emf.createEntityManager();
		
		Pagamento pagamento = new Pagamento ();
		
		Hospede hospede = em.find(Hospede.class, idHospede);
		
		pagamento.setHospede(hospede);
		pagamento.setStatus(Statuspagamento);
		pagamento.setDataPagamento(dataPagamento);
		pagamento.setTipoPagamento(tipoPagamento);
		
		
		em.getTransaction().begin();
		em.persist(pagamento);
		em.getTransaction().commit();
		em.close();
		
	
		
	}

}
