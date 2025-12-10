package dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Atendente;
import model.Hospede;

public class HospedeDAO extends MetodosGenericosDAO<Hospede>{

	public HospedeDAO() {
		super(Hospede.class);

	}
	
	public List<Hospede> buscarPorNome(String nomeBuscado) {
		
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	
	        String jpql = "SELECT h FROM Hospede h WHERE h.nome LIKE :nome";
	        TypedQuery<Hospede> query = em.createQuery(jpql, Hospede.class);
	        query.setParameter("nome", "%" + nomeBuscado + "%");
	        
	        return query.getResultList();
	        
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        return new ArrayList<>();
	        
	    } finally {
	            em.close();
	        
	    }
	}

	public boolean existeCpf(String cpf) {
		
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	
	        String jpql = "SELECT COUNT(h) FROM Hospede h WHERE h.cpf = :cpf";
	        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
	        query.setParameter("cpf", cpf);
	        
	        Long contagem = query.getSingleResult();
	        return contagem > 0;
	        
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        return false;
	        
	    } finally {
	            em.close();
	        
	    }
	}
}
