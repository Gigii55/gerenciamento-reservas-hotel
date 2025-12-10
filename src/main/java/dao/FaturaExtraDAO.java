package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.FaturaExtra;

public class FaturaExtraDAO extends MetodosGenericosDAO<FaturaExtra> {
	
	public FaturaExtraDAO() {
		super(FaturaExtra.class);
		
	}
	
	public List<FaturaExtra> buscarPorValor(double valorBuscado) {
		
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	
	        String jpql = "SELECT f FROM FaturaExtra f WHERE f.valor = :valor";
	        TypedQuery<FaturaExtra> query = em.createQuery(jpql, FaturaExtra.class);
	        query.setParameter("valor", valorBuscado);
	        
	        return query.getResultList();
	        
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        return new ArrayList<>();
	        
	    } finally {

	            em.close();
	        
	    }
	}

	public List<FaturaExtra> listarPorFatura(Long idFatura) {
		
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	
	        String jpql = "SELECT fe FROM FaturaExtra fe WHERE fe.fatura.id = :id";
	        TypedQuery<FaturaExtra> query = em.createQuery(jpql, FaturaExtra.class);
	        query.setParameter("id", idFatura);
	        
	        return query.getResultList();
	        
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        return new ArrayList<>();
	        
	    } finally {
	     
	            em.close();
	        
	    }
	}
}
