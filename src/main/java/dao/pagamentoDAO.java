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
		
		String jpql = "SELECT p FROM Pagamento p WHERE p.id_hospede = :id_hospede";
		
		TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
		query.setParameter("id_hospede", idHospede);
	
		List<Pagamento> lista = query.getResultList();
	
		em.close();
	
		return lista;
	}
	
	public List<Pagamento> buscarPorStatus(StatusPagamento statusBuscado) {
        
        EntityManager em = emf.createEntityManager();
        
       
        String jpql = "SELECT p FROM Pagamento p WHERE p.status = :status";
        
        TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
        query.setParameter("status", statusBuscado);            
        List<Pagamento> lista = query.getResultList();     
        em.close();
        
        return lista;
    }
}
