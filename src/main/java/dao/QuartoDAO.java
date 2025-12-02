package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Quarto;
import model.Tipo;

public class QuartoDAO extends MetodosGenericosDAO<Quarto>{

	public QuartoDAO() {
		super(Quarto.class);
		
	}
	
		public List<Quarto> buscarPorQuantidadeCamas(int qtd) {
        
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT q FROM Quarto q WHERE q.quantidadeCamas = :quantidade_camas";
        
        TypedQuery<Quarto> query = em.createQuery(jpql, Quarto.class);
        query.setParameter("quantidade_camas", qtd);
        
        List<Quarto> lista = query.getResultList();
        em.close();
        
        return lista;
    }

   
     public List<Quarto> buscarPorTipo(Tipo tipoBuscado) {
        
        EntityManager em = emf.createEntityManager();
        
        String jpql = "SELECT q FROM Quarto q WHERE q.tipoQuarto = :tipo";
        
        TypedQuery<Quarto> query = em.createQuery(jpql, Quarto.class);
        query.setParameter("tipo", tipoBuscado);
        
        List<Quarto> lista = query.getResultList();
        em.close();
        
        return lista;
    }

    
     public List<Quarto> buscarPorOrcamentoMaximo(double valorMaximo) {
        
        EntityManager em = emf.createEntityManager();
        
        String jpql = "SELECT q FROM Quarto q WHERE q.valorDiaria <= :valor_diaria";
        
        TypedQuery<Quarto> query = em.createQuery(jpql, Quarto.class);
        query.setParameter("valor_diaria", valorMaximo);
        
        List<Quarto> lista = query.getResultList();
        em.close();
        
        return lista;
    }
     
     
}