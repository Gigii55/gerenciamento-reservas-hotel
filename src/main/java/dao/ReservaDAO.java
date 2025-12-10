package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import model.Quarto;
import model.Reserva;
import model.Status;

public class ReservaDAO extends MetodosGenericosDAO<Reserva> {

    public ReservaDAO() {
        super(Reserva.class);
    }

    public List<Reserva> buscarPorDataReserva(Date dataBuscada) {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            String jpql = "SELECT r FROM Reserva r WHERE r.dataReserva = :data";
            TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
            query.setParameter("data", dataBuscada, TemporalType.DATE);

            return query.getResultList();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new ArrayList<>();
            
        } finally {
           
                em.close();
            
        }
    }

    public List<Reserva> buscarPorIdAtendente(Long idAtendente) {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
         
            String jpql = "SELECT r FROM Reserva r WHERE r.atendente.id = :id_atendente";
            TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
            query.setParameter("id_atendente", idAtendente);

            return query.getResultList();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new ArrayList<>();
            
        } finally {
          
                em.close();
            
        }
    }

    public List<Reserva> buscarPorIdHospede(Long idHospede) {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
       
            String jpql = "SELECT r FROM Reserva r WHERE r.hospede.id = :id_hospede";
            TypedQuery<Reserva> query = em.createQuery(jpql, Reserva.class);
            query.setParameter("id_hospede", idHospede);

            return query.getResultList();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new ArrayList<>();
            
        } finally {
        	
                em.close();
            }      
    }

    public Long contarReservasConflitantes(Quarto quarto, Date entrada, Date saida) {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            String jpql = "SELECT COUNT(r) FROM Reserva r " +
                          "WHERE r.quarto.id = :idQuarto " +
                          "AND r.dataCheckin < :saida " +
                          "AND r.dataCheckout > :entrada";

            TypedQuery<Long> query = em.createQuery(jpql, Long.class);

            query.setParameter("idQuarto", quarto.getId());
            query.setParameter("entrada", entrada);
            query.setParameter("saida", saida);

            return query.getSingleResult();
            		
        } catch (Exception e) {
        	
            e.printStackTrace();
            return 0L;

        } finally {
        	
          
                em.close();
            
        }
    }

    public Long relatorioOcupacaoHoje() {
    	
        EntityManager em = emf.createEntityManager();
        
        try {
        	
            Date hoje = new Date();

            String jpql = "SELECT COUNT(r) FROM Reserva r WHERE " +
                          "r.dataCheckin <= :hoje AND r.dataCheckout > :hoje " +
                          "AND r.status = :ocupado";

            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            query.setParameter("hoje", hoje);
            query.setParameter("ocupado", Status.OCUPADO);

            return query.getSingleResult();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return 0L;
            
        } finally {
          
                em.close();
            
        }
    }
}