package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.*;
import services.HospedeService;
import services.HotelService;
import services.LoginService;
import services.ReservaService;
import dao.*;

public class Teste {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

     
        LoginService loginService = new LoginService();
        HotelService hotelService = new HotelService();
        ReservaService reservaService = new ReservaService();
        HospedeService hospedeService = new HospedeService();

     
        AtendenteDAO atendenteDAO = new AtendenteDAO();
        HospedeDAO hospedeDAO = new HospedeDAO();
        QuartoDAO quartoDAO = new QuartoDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
        FaturaDAO faturaDAO = new FaturaDAO();

        Atendente usuarioLogado = null;

        System.out.println("=========================================");
        System.out.println("      SISTEMA DE GESTÃO DE HOTEL");
        System.out.println("=========================================");

  
        while (usuarioLogado == null) {
        	
            System.out.println("\n--- LOGIN ---");
            System.out.print("E-mail: ");
            
            String email = scanner.nextLine();
            
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            usuarioLogado = loginService.fazerLogin(email, senha);
            
            if (usuarioLogado == null) {
            	
                System.out.println(">> Dados incorretos. Tente novamente.");
            }
        }

     
        int opcao = -1;
        
        while (opcao != 0) {
        	
            System.out.println("\n-----------------------------------------");
            System.out.println("Bem-vindo(a): " + usuarioLogado.getNome());
            System.out.println("1. Cadastrar Hóspede");
            System.out.println("2. Nova Reserva");
            System.out.println("3. Realizar Check-In");
            System.out.println("4. Realizar Check-Out");
            System.out.println("5. Listar Quartos");
            System.out.println("6. Listar Hóspedes");
            System.out.println("7. Relatório de Ocupação (Hoje)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
            	
                String input = scanner.nextLine();
                
                if (input.isEmpty()) continue;
                opcao = Integer.parseInt(input);
                
            } catch (NumberFormatException e) {
            	
                System.out.println("Opção inválida!");
                opcao = -1;
            }

           
            try {
            	
                switch (opcao) {
                
                    case 1: 
                    	
                        System.out.println("\n--- NOVO HÓSPEDE ---");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Email: ");
                        String emailHosp = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String tel = scanner.nextLine();
                        System.out.print("Nascimento: ");
                        Date dataNasc = sdf.parse(scanner.nextLine());

                        Hospede h = new Hospede();
                        h.setNome(nome); h.setCpf(cpf); h.setEmail(emailHosp);
                        h.setTelefone(tel); h.setDataNascimento(dataNasc);
                        
                        hospedeService.cadastrarHospede(h);
                        break;

                    case 2: 
                    	
                        System.out.println("\n--- NOVA RESERVA ---");
                        System.out.print("ID do Hóspede: ");
                        Long idH = Long.parseLong(scanner.nextLine());
                        Hospede hosp = hospedeDAO.buscarPorId(idH);

                        System.out.print("ID do Quarto: ");
                        Long idQ = Long.parseLong(scanner.nextLine());
                        Quarto quart = quartoDAO.buscarPorId(idQ);

                        if (hosp != null && quart != null) {
                            System.out.print("Data Entrada (dd/MM/yyyy): ");
                            Date in = sdf.parse(scanner.nextLine());
                            System.out.print("Data Saída (dd/MM/yyyy): ");
                            Date out = sdf.parse(scanner.nextLine());

                            Reserva r = new Reserva();
                            r.setHospede(hosp);
                            r.setQuarto(quart);
                            r.setAtendente(usuarioLogado);
                            r.setDataReserva(new Date());
                            r.setDataCheckin(in);
                            r.setDataCheckout(out);
                            r.setStatus(Status.DISPONÍVEL);

                            reservaService.criarReserva(r);
                        } else {
                            System.out.println("Hóspede ou Quarto não encontrados.");
                        }
                        break;

                    case 3: 

                        System.out.println("\n--- CHECK-IN ---");
                        System.out.print("ID da Reserva: ");
                        Long idResIn = Long.parseLong(scanner.nextLine());
                        hotelService.realizarCheckIn(idResIn);
                        break;

                    case 4:

                        System.out.println("\n--- CHECK-OUT ---");
                        System.out.print("ID da Reserva: ");
                        Long idResOut = Long.parseLong(scanner.nextLine());
                        
                        System.out.println("Forma de Pagamento:");
                        System.out.println("1. PIX");
                        System.out.println("2. Cartão de Crédito");
                        System.out.println("3. Cartão de Débito");
                        System.out.println("4. Dinheiro");
                        System.out.print("Escolha: ");
                        
                        int tipoPag = Integer.parseInt(scanner.nextLine());
                        
                        TipoPagamento tipoSelecionado = TipoPagamento.DINHEIRO;
                        
                        switch(tipoPag) {
                        
                            case 1: tipoSelecionado = TipoPagamento.PIX; break;
                            case 2: tipoSelecionado = TipoPagamento.CARTAO_CREDITO; break;
                            case 3: tipoSelecionado = TipoPagamento.CARTAO_DEBITO; break;
                            case 4: tipoSelecionado = TipoPagamento.DINHEIRO; break;
                            
                            default: System.out.println("Opção inválida, assumindo Dinheiro.");
                        }
                        
                    
                        hotelService.realizarCheckOut(idResOut, tipoSelecionado);
                        
                    case 5: 
                    	
                    	
                        System.out.println("\n--- LISTA DE QUARTOS ---");
                        
                        List<Quarto> listaQ = quartoDAO.listarTodos();
                        
                        for (Quarto q : listaQ) {
                            System.out.println("ID: " + q.getId() + " | Quarto: " + q.getNumeroQuarto() + 
                                               " | Status: " + q.getStatus() + " | Tipo: " + q.getTipoQuarto());
                        }
                        
                        break;

                    case 6: 
                    	
                        System.out.println("\n--- LISTA DE HÓSPEDES ---");
                        List<Hospede> listaH = hospedeDAO.listarTodos();
                        for (Hospede hos : listaH) {
                            System.out.println("ID: " + hos.getId() + " | Nome: " + hos.getNome() + 
                                               " | CPF: " + hos.getCpf());
                        }
                        break;

                    case 7: 

                        System.out.println("\n--- RELATÓRIO ---");
                        Long qtd = reservaDAO.relatorioOcupacaoHoje();
                        System.out.println("Quartos ocupados hoje: " + qtd);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro na operação: " + e.getMessage());
              
            }
        }
        
        scanner.close();
    }
}