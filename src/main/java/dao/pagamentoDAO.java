package dao;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import model.Fatura;
import model.Hospede;
import model.Pagamento;
import model.Reserva;
import model.StatusPagamento;
import model.TipoPagamento;


public class PagamentoDAO extends MetodosGenericosDAO<Pagamento> {

	public PagamentoDAO() {
		super(Pagamento.class);
	}
	
	public List<Reserva> buscarPorDataPagamento(Date dataBuscada) {
	    
	    EntityManager em = emf.createEntityManager();
	    
	    String jpql = "SELECT p FROM Pagamento p WHERE p.dataPagamento = :dataBuscada";
	    TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
	    query.setParameter("dataBuscada", dataBuscada, TemporalType.DATE);
	   
	    List<Reserva> lista = query.getResultList(); 
	   
	    em.close();
	    
	    return lista;
	}

	public List<Pagamento> buscarPorIdHospede(Long idHospede) {
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT p FROM Pagamento p WHERE p.hospede.id = :id";
		
		TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
		query.setParameter("id", idHospede);
	
		List<Pagamento> lista = query.getResultList();
	
		em.close();
	
		return lista;
	}
}
