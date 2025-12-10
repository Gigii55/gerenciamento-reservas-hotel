package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class MetodosGenericosDAO<T> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");
    
    private Class<T> classeEntidade;

    public MetodosGenericosDAO(Class<T> classeEntidade) {
    	
        this.classeEntidade = classeEntidade;
    }
    
    public void deletarRegistroPorID(long id) {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            T entidade = em.find(classeEntidade, id);
            
            em.getTransaction().begin();
            
            if (entidade != null) {
                em.remove(entidade);
            }
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
           
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
        } finally {
        	
                em.close();     
        }
    }
    
    public T buscarPorId(Object id) {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            return em.find(classeEntidade, id);
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return null;
            
        } finally {

                em.close();
            
        }
    }
    
    public T adicionar(T entidade) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
          
            T entidadeSalva = em.merge(entidade); 
            
            em.getTransaction().commit();
            
          
            return entidadeSalva; 
            
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        } finally {
            em.close();
        }
    }

    public List<T> listarTodos() {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            String jpql = "SELECT t FROM " + classeEntidade.getSimpleName() + " t";
            TypedQuery<T> query = em.createQuery(jpql, classeEntidade);
            return query.getResultList();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new ArrayList<>();
            
        } finally {
           
                em.close();
            }
        
    }
}