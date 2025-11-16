    package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Atendente;
import model.Hospede;
import model.Reserva;
import model.Status;

public class ReservaDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");
	
	public void adicionarReserva (Long idAtendente, Long idHospede, Date dataReserva, 
			Date dataCheckin, Date dataCheckout, Status status) {
					
		EntityManager em = emf.createEntityManager();
		
		Atendente atendente = em.find(Atendente.class, idAtendente);
		Hospede hospede = em.find(Hospede.class, idHospede);
		
		Reserva reserva = new Reserva();
		reserva.setAtendente(atendente);
		reserva.setHospede(hospede);
		reserva.setDataReserva(dataReserva);
		reserva.setDataCheckin(dataCheckin);
		reserva.setDataCheckout(dataCheckout);
		reserva.setStatus(status);
		
		em.getTransaction().begin();
		em.persist(reserva);
		em.getTransaction().commit();
		em.close();
		
	}


}