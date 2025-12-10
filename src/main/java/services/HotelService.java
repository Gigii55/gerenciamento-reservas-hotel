package services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dao.*;
import model.*;

public class HotelService {

    private ReservaDAO reservaDAO = new ReservaDAO();
    private QuartoDAO quartoDAO = new QuartoDAO();
    private FaturaDAO faturaDAO = new FaturaDAO();
    private FaturaExtraDAO faturaExtraDAO = new FaturaExtraDAO();

   
    public void realizarCheckIn(Long idReserva) {
        
        Reserva reserva = reservaDAO.buscarPorId(idReserva);
        
        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        reserva.setStatus(Status.OCUPADO);
        reservaDAO.adicionar(reserva); 

        Quarto quarto = reserva.getQuarto();
        quarto.setStatus(Status.OCUPADO);
        quartoDAO.adicionar(quarto); 

        // 3. Abre a Fatura (Conta do Hóspede)
        
        Fatura novaFatura = new Fatura();
        novaFatura.setHospede(reserva.getHospede());
        novaFatura.setValorTotal(0.0); 
        novaFatura.setDesconto(0.0);
        novaFatura.setStatusPagamento(StatusPagamento.PENDENTE);
        novaFatura.setDataFechamento(null);
        
        faturaDAO.adicionar(novaFatura);

        System.out.println("CHECK-IN REALIZADO!");

    }

    // --- PROCESSO DE CHECK-OUT ---
    public void realizarCheckOut(Long idReserva, Long idFatura) {
        
        Reserva reserva = reservaDAO.buscarPorId(idReserva);
        Fatura fatura = faturaDAO.buscarPorId(idFatura);
        Quarto quarto = reserva.getQuarto();

        
        long diferencaMs = reserva.getDataCheckout().getTime() - reserva.getDataCheckin().getTime();
        long dias = TimeUnit.DAYS.convert(diferencaMs, TimeUnit.MILLISECONDS);
    
        if (dias == 0) dias = 1;

        double totalDiarias = dias * quarto.getValorDiaria();
        System.out.println("Total Diárias (" + dias + " dias): R$ " + totalDiarias);

        
        double totalExtras = 0.0;
        
        List<FaturaExtra> extras = faturaExtraDAO.listarPorFatura(fatura.getId());
        
        for (FaturaExtra item : extras) {
            totalExtras += item.getValor();
        }
        System.out.println("Total Extras: R$ " + totalExtras);

        double valorFinal = totalDiarias + totalExtras;
        
        fatura.setValorTotal(valorFinal);
        fatura.setStatusPagamento(StatusPagamento.PAGO);
        fatura.setDataFechamento(new Date());
        faturaDAO.adicionar(fatura);

      
        reserva.setStatus(Status.DISPONÍVEL);
        reservaDAO.adicionar(reserva);

        quarto.setStatus(Status.AGUARDANDO_LIMPEZA);
        quartoDAO.adicionar(quarto);

        System.out.println("CHECK-OUT REALIZADO!");
        
        
    }
    
    public void bloquearQuartoParaManutencao(Long idQuarto) {
        Quarto quarto = quartoDAO.buscarPorId(idQuarto);
        
        if (quarto != null) {
            
            if (quarto.getStatus() == Status.OCUPADO) {
                System.out.println("Erro: Não pode bloquear quarto ocupado!");
                return;
            }
            
            quarto.setStatus(Status.EM_MANUTENÇÃO);
            quartoDAO.adicionar(quarto);
            System.out.println("Quarto " + quarto.getNumeroQuarto() + " bloqueado para manutenção.");
        }
    }
}