package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import model.Fatura;
import model.FaturaExtra;
import model.Reserva;
import model.Status;
import model.StatusPagamento;

public class FaturaDAO extends MetodosGenericosDAO<Fatura>{
	
	public FaturaDAO() {
		super(Fatura.class);
		
	}

	public List<Reserva> buscarPorDataFechamento(Date dataBuscada) {
	    
	    EntityManager em = emf.createEntityManager();
	    
	    String jpql = "SELECT f FROM Fatura f WHERE f.data_fechamento = :dataBuscada";
	    TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
	    query.setParameter("dataBuscada", dataBuscada, TemporalType.DATE);
	   
	    List<Reserva> lista = query.getResultList(); 
	   
	    em.close();
	    
	    return lista;
	}
	
	public List<Fatura> buscarPorStatus(StatusPagamento statusBuscado) {
	    
	    EntityManager em = emf.createEntityManager();
	    	  
	    String jpql = "SELECT f FROM Fatura f WHERE f.statusPagamento = :status_pagamento";  
	    TypedQuery<Fatura> query = em.createQuery(jpql, Fatura.class);
	    query.setParameter("status_pagamento", statusBuscado);	  
	    List<Fatura> lista = query.getResultList();
	    em.close();	    	  
	    return lista;
	}
	

	public List<FaturaExtra> listarPorFatura(Long idFatura) {
		
	    EntityManager em = emf.createEntityManager();
	    String jpql = "SELECT fe FROM FaturaExtra fe WHERE fe.fatura.id = :id";
	    TypedQuery<FaturaExtra> query = em.createQuery(jpql, FaturaExtra.class);
	    query.setParameter("id", idFatura);
	    List<FaturaExtra> lista = query.getResultList();
	    em.close();
	    return lista;
	}
	
	
}
