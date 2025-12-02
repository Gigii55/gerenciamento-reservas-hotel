package dao;
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
	        
	        String jpql = "SELECT h FROM Hospede h WHERE h.nome LIKE :nome";
	        
	        TypedQuery<Hospede> query = em.createQuery(jpql, Hospede.class);
	        
	        query.setParameter("nome", "%" + nomeBuscado + "%");
	        
	        List<Hospede> lista = query.getResultList();
	        
	        em.close();
	        
	        return lista;
	    }

}
