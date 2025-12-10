package services;

import dao.ReservaDAO;
import model.Reserva;

public class ReservaService {

    private ReservaDAO reservaDAO = new ReservaDAO();

		
		
    public void criarReserva(Reserva novaReserva) {
        
     
        if (novaReserva.getDataCheckout().getTime() < novaReserva.getDataCheckin().getTime()) {
            System.out.println("❌ ERRO: Data de saída inválida (antes da entrada).");
            return; 
        }

     
        Long conflitos = reservaDAO.contarReservasConflitantes(
                            novaReserva.getQuarto(), 
                            novaReserva.getDataCheckin(), 
                            novaReserva.getDataCheckout());
        
        if (conflitos > 0) {
            System.out.println("❌ ERRO: O Quarto já está ocupado nessas datas.");
            return; 
        }

      
        reservaDAO.adicionar(novaReserva); 
        System.out.println("✅ SUCESSO: Reserva criada para o hóspede " + novaReserva.getHospede().getNome());
    }
}