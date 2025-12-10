package dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Idioma;

public class IdiomaDAO extends MetodosGenericosDAO<Idioma> {

	public IdiomaDAO() {
		super(Idioma.class);
	}
	
	public List<Idioma> buscarPorNome(String nomeBuscado) {
		
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	
	        String jpql = "SELECT i FROM Idioma i WHERE i.nome LIKE :nome";
	        TypedQuery<Idioma> query = em.createQuery(jpql, Idioma.class);
	        query.setParameter("nome", "%" + nomeBuscado + "%");
	        
	        return query.getResultList();
	        
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        return new ArrayList<>();
	        
	    } finally {   
	            em.close();
	       
	    }
	}
	
}
