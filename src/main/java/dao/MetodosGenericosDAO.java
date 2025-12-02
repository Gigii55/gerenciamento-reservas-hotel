package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Reserva;

public abstract class MetodosGenericosDAO <T> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");
	
	private Class<T> classeEntidade;

    public MetodosGenericosDAO(Class<T> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }
    
	public void deletarRegistroPorID(long id) {
		
		EntityManager em = emf.createEntityManager();
		T entidade = em.find(classeEntidade, id);
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	public T buscarPorId(Object id) {
		
		EntityManager em = emf.createEntityManager();
		T resultado = em.find(classeEntidade, id);
		em.close();
		
        return resultado;
	}
	
	public void adicionar(T entidade) {
		
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();                 
	    em.merge(entidade);                          
	    em.getTransaction().commit();              
	    em.close();                                  
	}
	

	public List<T> listarTodos() {
	    
	    EntityManager em = emf.createEntityManager();
	    String jpql = "SELECT t FROM " + classeEntidade.getSimpleName() + " t";
	    TypedQuery<T> query = em.createQuery(jpql, classeEntidade);
	    List<T> lista = query.getResultList();
	    em.close();
	    return lista;
	}
	
	
	}
