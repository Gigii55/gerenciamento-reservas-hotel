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
    
    // --- OBRIGATÓRIO: O DAO DE PAGAMENTO TEM QUE ESTAR AQUI ---
    private PagamentoDAO pagamentoDAO = new PagamentoDAO(); 

    public void realizarCheckIn(Long idReserva) {
        Reserva reserva = reservaDAO.buscarPorId(idReserva);
        
        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        reserva.setStatus(Status.OCUPADO);
        Quarto quarto = reserva.getQuarto();
        quarto.setStatus(Status.OCUPADO);
        quartoDAO.adicionar(quarto);

        Fatura novaFatura = new Fatura();
        novaFatura.setHospede(reserva.getHospede());
        novaFatura.setValorTotal(0.0);
        novaFatura.setDesconto(0.0);
        novaFatura.setStatusPagamento(StatusPagamento.PENDENTE);
        novaFatura.setDataFechamento(null);
        
        novaFatura = faturaDAO.adicionar(novaFatura);

        reserva.setFatura(novaFatura);
        reservaDAO.adicionar(reserva);

        System.out.println("CHECK-IN REALIZADO! Quarto " + quarto.getNumeroQuarto() + " ocupado.");
    }

    public void realizarCheckOut(Long idReserva, TipoPagamento tipoPagamento) {
        
        System.out.println(">> Iniciando processo de Check-out..."); // LOG DE DEBUG

        Reserva reserva = reservaDAO.buscarPorId(idReserva);
        
        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        Fatura fatura = reserva.getFatura();
        if (fatura == null) {
            System.out.println("ERRO CRÍTICO: Reserva sem fatura vinculada.");
            return;
        }

        Quarto quarto = reserva.getQuarto();

        // 1. CÁLCULOS
        long diferencaMs = reserva.getDataCheckout().getTime() - reserva.getDataCheckin().getTime();
        long dias = TimeUnit.DAYS.convert(diferencaMs, TimeUnit.MILLISECONDS);
        if (dias == 0) dias = 1;

        double totalDiarias = dias * quarto.getValorDiaria();
        double totalExtras = 0.0;
        List<FaturaExtra> extras = faturaExtraDAO.listarPorFatura(fatura.getId());
        for (FaturaExtra item : extras) {
            totalExtras += item.getValor();
        }

        double valorFinal = totalDiarias + totalExtras;

        System.out.println("\n--- RESUMO DA CONTA ---");
        System.out.println("Diárias (" + dias + " dias): R$ " + totalDiarias);
        System.out.println("Consumo Extra: R$ " + totalExtras);
        System.out.println("TOTAL A PAGAR: R$ " + valorFinal);
        System.out.println("-----------------------");

        // 2. REGISTRAR O PAGAMENTO
        Pagamento novoPagamento = new Pagamento();
        novoPagamento.setHospede(reserva.getHospede());
        novoPagamento.setStatus(StatusPagamento.PAGO);
        novoPagamento.setTipoPagamento(tipoPagamento);
        novoPagamento.setDataPagamento(new Date());
        
        // TENTA SALVAR NO BANCO
        try {
            pagamentoDAO.adicionar(novoPagamento);
            System.out.println(">> Pagamento salvo no banco com ID: " + novoPagamento.getId());
        } catch (Exception e) {
            System.out.println("ERRO AO SALVAR PAGAMENTO: " + e.getMessage());
        }

        // 3. FECHAR A FATURA
        fatura.setValorTotal(valorFinal);
        fatura.setStatusPagamento(StatusPagamento.PAGO);
        fatura.setDataFechamento(new Date());
        faturaDAO.adicionar(fatura);

        // 4. LIBERAR QUARTO E RESERVA
        reserva.setStatus(Status.DISPONÍVEL);
        reservaDAO.adicionar(reserva);

        quarto.setStatus(Status.AGUARDANDO_LIMPEZA);
        quartoDAO.adicionar(quarto);

        System.out.println("✅ CHECK-OUT CONCLUÍDO!");
    }
    
    public void liberarQuartoAposLimpeza(Long idQuarto) {
        Quarto quarto = quartoDAO.buscarPorId(idQuarto);
        
        if (quarto == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        if (quarto.getStatus() == Status.AGUARDANDO_LIMPEZA) {
            quarto.setStatus(Status.DISPONÍVEL);
            quartoDAO.adicionar(quarto);
            System.out.println("✅ Quarto " + quarto.getNumeroQuarto() + " limpo e disponível para novas reservas!");
        } else {
            System.out.println("⚠️ Este quarto não está aguardando limpeza. Status atual: " + quarto.getStatus());
        }
    }
}