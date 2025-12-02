package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Atendente;

public class AtendenteDAO extends MetodosGenericosDAO <Atendente>{

	public AtendenteDAO() {
		super(Atendente.class);
	}


    public List<Atendente> buscarPorNome(String nomeBuscado) {
        
        EntityManager em = emf.createEntityManager();
        
        String jpql = "SELECT a FROM Atendente a WHERE a.nome LIKE :nome";
        
        TypedQuery<Atendente> query = em.createQuery(jpql, Atendente.class);
        
        query.setParameter("nome", "%" + nomeBuscado + "%");
        
        List<Atendente> lista = query.getResultList();
        
        em.close();
        
        return lista;
    }

}
