package dao;

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
          
        String jpql = "SELECT f FROM FaturaExtra f WHERE f.valor = :valor";
        
        TypedQuery<FaturaExtra> query = em.createQuery(jpql, FaturaExtra.class);
        query.setParameter("valor", valorBuscado);
        
        List<FaturaExtra> lista = query.getResultList();
        
        em.close();
        
        return lista;
    }
}
