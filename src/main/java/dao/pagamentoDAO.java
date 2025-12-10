package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import model.Pagamento;
import model.StatusPagamento;

public class PagamentoDAO extends MetodosGenericosDAO<Pagamento> {

    public PagamentoDAO() {
        super(Pagamento.class);
    }

    public List<Pagamento> buscarPorDataPagamento(Date dataBuscada) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            String jpql = "SELECT p FROM Pagamento p WHERE p.dataPagamento = :dataBuscada";
            TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
            query.setParameter("dataBuscada", dataBuscada, TemporalType.DATE);
            
            return query.getResultList();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new ArrayList<>();
            
        } finally {
      
                em.close();
            
        }
    }

    public List<Pagamento> buscarPorIdHospede(Long idHospede) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
            
            String jpql = "SELECT p FROM Pagamento p WHERE p.id_hospede = :id_hospede";
            
            TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
            query.setParameter("id_hospede", idHospede);
        
            return query.getResultList();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new ArrayList<>();
            
        } finally {
       
               em.close();
            
        }
    }
    
    public List<Pagamento> buscarPorStatus(StatusPagamento statusBuscado) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            String jpql = "SELECT p FROM Pagamento p WHERE p.status = :status";
            TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
            query.setParameter("status", statusBuscado);            
            
            return query.getResultList();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new ArrayList<>();
            
        } finally {
       
                em.close();
            
        }
      }
}