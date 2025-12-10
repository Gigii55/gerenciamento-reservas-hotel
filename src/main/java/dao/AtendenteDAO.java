package dao;

import java.util.ArrayList;
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
        
        try {
        	
            String jpql = "SELECT a FROM Atendente a WHERE a.nome LIKE :nome";
            TypedQuery<Atendente> query = em.createQuery(jpql, Atendente.class);
            query.setParameter("nome", "%" + nomeBuscado + "%");
            
            return query.getResultList();

        } catch (Exception e) {
            
            System.out.println("Erro ao buscar atendente por nome: " + e.getMessage());
            e.printStackTrace(); 
            return new ArrayList<>(); 
            
        } finally {
                em.close();
            
        }
}
    public Atendente buscarPorEmail(String email) {
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            String jpql = "SELECT a FROM Atendente a WHERE a.email = :email";
            TypedQuery<Atendente> query = em.createQuery(jpql, Atendente.class);
            query.setParameter("email", email);
            
            return query.getSingleResult();
            
        } catch (Exception e) {
        	
            return null; 
            
        } finally {
        	
            em.close();
        }
    }

}
