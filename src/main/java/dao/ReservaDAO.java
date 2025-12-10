package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import model.Quarto;
import model.Reserva;
import model.Status;


public class ReservaDAO extends MetodosGenericosDAO <Reserva>{
	
	public ReservaDAO() {
		super(Reserva.class);
	}

	public List<Reserva> buscarPorDataReserva(Date dataBuscada) {
	    
	    EntityManager em = emf.createEntityManager();
	    
	    String jpql = "SELECT r FROM Reserva r WHERE r.dataReserva = :data";
	    TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
	    query.setParameter("data", dataBuscada, TemporalType.DATE);
	   
	    List<Reserva> lista = query.getResultList(); 
	   
	    em.close();
	    
	    return lista;
	}
	
	public List<Reserva> buscarPorIdAtendente(Long idAtendente) {
        
        EntityManager em = emf.createEntityManager();
        
        String jpql = "SELECT r FROM Reserva r WHERE r.id_atendente = :id_atendente";
        
        TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
        query.setParameter("id_atendente", idAtendente);
        
        List<Reserva> lista = query.getResultList();
        
        em.close();
        
        return lista;
    }

    
    public List<Reserva> buscarPorIdHospede(Long idHospede) {
        
        EntityManager em = emf.createEntityManager();
        
        String jpql = "SELECT r FROM Reserva r WHERE r.id_hospede = :id_hospede";
        
        TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
        query.setParameter("id_hospede", idHospede);
        
        List<Reserva> lista = query.getResultList();
        
        em.close();
        
        return lista;
    }
	
    public Long contarReservasConflitantes(Quarto quarto, Date entrada, Date saida) {
        
        EntityManager em = emf.createEntityManager();
        
       
        String jpql = "SELECT COUNT(r) FROM Reserva r " +
                      "WHERE r.quarto.id = :idQuarto " +
                      "AND r.dataCheckin < :saida " +
                      "AND r.dataCheckout > :entrada";
        
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        
        query.setParameter("idQuarto", quarto.getId());
        query.setParameter("entrada", entrada);
        query.setParameter("saida", saida);
        
        Long resultado = query.getSingleResult();
        em.close();
        
        return resultado;
    }
    
 
    public Long relatorioOcupacaoHoje() {
        EntityManager em = emf.createEntityManager();
        Date hoje = new Date();
        
        String jpql = "SELECT COUNT(r) FROM Reserva r WHERE " +
                      "r.dataCheckin <= :hoje AND r.dataCheckout > :hoje " +
                      "AND r.status = :ocupado"; 
                      
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("hoje", hoje);
        query.setParameter("ocupado", Status.OCUPADO); 
        
        Long ocupados = query.getSingleResult();
        em.close();
        return ocupados;
    }
}