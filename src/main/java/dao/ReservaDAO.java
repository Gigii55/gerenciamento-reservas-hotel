package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import model.Reserva;


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
	
}