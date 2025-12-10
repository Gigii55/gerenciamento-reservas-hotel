package dao;
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
	    String jpql = "SELECT c FROM Comodidades c WHERE c.tipo = :tipo";
	    TypedQuery<Comodidades> query = em.createQuery(jpql, Comodidades.class);
	    query.setParameter("tipo", tipoBuscado);
	    List<Comodidades> lista = query.getResultList();
	    em.close();
	    return lista;
	}
	
}
