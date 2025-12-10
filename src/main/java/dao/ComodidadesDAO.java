package dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Comodidades;
import model.TipoComodidades;



public class ComodidadesDAO extends MetodosGenericosDAO <Comodidades>{

	public ComodidadesDAO() {
		super(Comodidades.class);
		
	}

	public List<Comodidades> buscarPorTipo(TipoComodidades tipoBuscado) {
		
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	
	        String jpql = "SELECT c FROM Comodidades c WHERE c.tipo = :tipo";
	        TypedQuery<Comodidades> query = em.createQuery(jpql, Comodidades.class);
	        query.setParameter("tipo", tipoBuscado);
	        
	        return query.getResultList();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ArrayList<>();
	        
	    } finally {
	            em.close();
	        
	    }
	}
}
