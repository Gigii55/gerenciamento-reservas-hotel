package main;

import java.util.Date;
import java.util.List;

import dao.AtendenteDAO;
import dao.ComodidadesDAO;
import dao.FaturaDAO;
import dao.FaturaExtraDAO;
import dao.HospedeDAO;
import dao.IdiomaAtendenteDAO;
import dao.IdiomaDAO;
import dao.PagamentoDAO;
import dao.QuartoComodidadesDAO;
import dao.QuartoDAO;
import dao.ReservaDAO;
import model.Atendente;
import model.Comodidades;
import model.Fatura;
import model.FaturaExtra;
import model.Hospede;
import model.Idioma;
import model.Pagamento;
import model.Quarto;
import model.Reserva;
import model.Status;
import model.StatusPagamento;
import model.Tipo;
import model.TipoComodidades;
import model.TipoPagamento;
import services.HospedeService;
import services.HotelService;
import services.ReservaService;



public class Teste {

    public static void main(String[] args) {

    
        IdiomaDAO idiomaDAO = new IdiomaDAO();
        ComodidadesDAO comodidadesDAO = new ComodidadesDAO();
        AtendenteDAO atendenteDAO = new AtendenteDAO();
        HospedeDAO hospedeDAO = new HospedeDAO();   
        FaturaDAO faturaDAO = new FaturaDAO();
        FaturaExtraDAO faturaExtraDAO = new FaturaExtraDAO();
        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        QuartoDAO quartoDAO = new QuartoDAO();
        ReservaDAO  reservaDAO = new ReservaDAO();
        IdiomaAtendenteDAO idiomaAtendenteDAO = new IdiomaAtendenteDAO();
        QuartoComodidadesDAO quartoComodidadesDAO = new QuartoComodidadesDAO();
        ReservaService service = new ReservaService();
        HospedeService hservice = new HospedeService ();
        HotelService htservice = new HotelService();
        FaturaExtraDAO extra = new FaturaExtraDAO();
      
        Quarto quarto101 = quartoDAO.buscarPorId(1L); 
        Atendente atendente = atendenteDAO.buscarPorId(3L);
        Hospede hospede = hospedeDAO.buscarPorId(2L);

       // System.out.println("--- TESTE 1: Reserva Válida ---");
      //  Reserva r1 = new Reserva();
      //  r1.setQuarto(quarto101);       
      //  r1.setAtendente(atendente);   
       // r1.setHospede(hospede);        
       // r1.setStatus(Status.DISPONÍVEL);

      
      //  r1.setDataReserva(new Date()); 
       // r1.setDataCheckin(new Date(126, 0, 10)); 
       // r1.setDataCheckout(new Date(126, 0, 15));

        // AGORA SIM PODE CHAMAR
      //  service.criarReserva(r1);
     //   System.out.println("\n--- TESTE 2: Data Errada ---");
      //  Reserva r2 = new Reserva();
       // r1.setQuarto(quarto101);       
     //   r1.setAtendente(atendente);   
     //   r1.setHospede(hospede);        
     //   r1.setStatus(Status.DISPONÍVEL);

      
       // r1.setDataReserva(new Date());
      //  r1.setDataCheckin(new Date(126, 0, 15)); 
      //  r1.setDataCheckout( new Date(126, 0, 10));

     //  service.criarReserva(r2);

    
       // Hospede hMenor = new Hospede();
      //  hMenor.setNome("Enzo Gabriel");
       // hMenor.setCpf("999.999.999-00"); // CPF Aleatório
      //  hMenor.setEmail("enzo@teste.com");
       // hMenor.setTelefone("0000-0000");
       
      //  hMenor.setDataNascimento(new Date(115, 0, 1)); 
        //
 
        //hservice.cadastrarHospede(hMenor);
        
        
        //Hospede hClone = new Hospede();
        //  hClone.setNome("Maria Clonada"); 
        //  hClone.setCpf("123.456.789-00"); 
        // hClone.setEmail("maria@teste.com");
        //  hClone.setTelefone("2222-2222");
      
        //  hClone.setDataNascimento(new Date(95, 0, 1));
        //
        //   System.out.println("\nTentativa 2 (CPF Duplicado):");
        // hservice.cadastrarHospede(hClone); // Deve aparecer: ERRO
        
        
       // htservice.realizarCheckIn(22L);
        
        
       // Reserva r = reservaDAO.buscarPorId(22L);
      
       // List<Fatura> todasFaturas = faturaDAO.listarTodos();
      //  Fatura faturaAtiva = todasFaturas.get(todasFaturas.size() - 1); 
     
      //  FaturaExtra item1 = new FaturaExtra();
      //  item1.setFatura(faturaAtiva);
     //   item1.setDescricao("Hambúrguer Artesanal");
      //  item1.setValor(45.00);
      //  extra.adicionar(item1);
     //   System.out.println("   + Lançado: Hambúrguer (R$ 45,00)");

      //  FaturaExtra item2 = new FaturaExtra();
      //  item2.setFatura(faturaAtiva);
      //  item2.setDescricao("Refrigerante");
     //   item2.setValor(8.00);
       // extra.adicionar(item2);
      //  System.out.println("   + Lançado: Refrigerante (R$ 8,00)");

      
       // htservice.realizarCheckOut(22L, faturaAtiva.getId());
        
        Quarto q1 = quartoDAO.buscarPorId(1L);
        Quarto q2 = quartoDAO.buscarPorId(2L); // Use outro quarto
        Atendente at = atendenteDAO.buscarPorId(3L);
        Hospede ho = hospedeDAO.buscarPorId(13L);

        System.out.println("--- PREPARANDO CENÁRIO DE TESTE ---");

        // CASO 1: Hóspede que ESTÁ no hotel agora (OCUPADO) -> DEVE CONTAR
        Reserva r1 = new Reserva();
        r1.setQuarto(q1);
        r1.setAtendente(at);
        r1.setHospede(ho);
        r1.setStatus(Status.OCUPADO); // <--- O PULO DO GATO
        // De 2020 até 2030 (Hoje com certeza está aqui no meio)
        r1.setDataCheckin(new Date(120, 0, 1));  // Ano 2020
        r1.setDataCheckout(new Date(130, 0, 1)); // Ano 2030
        r1.setDataReserva(new Date(120, 0, 1));
        reservaDAO.adicionar(r1);
        System.out.println("Criada reserva OCUPADA (Deve contar).");

        // CASO 2: Reserva futura ou apenas agendada (DISPONIVEL) -> NÃO DEVE CONTAR
        Reserva r2 = new Reserva();
        r2.setQuarto(q2); // Outro quarto
        r2.setAtendente(at);
        r2.setHospede(ho);
        r2.setStatus(Status.DISPONÍVEL); // <--- AINDA NÃO FEZ CHECK-IN
        // Mesmo período (Hoje está no meio)
        r2.setDataCheckin(new Date(120, 0, 1));
        r2.setDataCheckout(new Date(130, 0, 1));
        r2.setDataReserva(new Date(120, 0, 2));
        reservaDAO.adicionar(r2);
        System.out.println("Criada reserva DISPONÍVEL (Não deve contar).");

        // -------------------------------------------------------
        // TESTE DO RELATÓRIO
        // -------------------------------------------------------
        System.out.println("\n--- GERANDO RELATÓRIO ---");
        
        Long quantidade = reservaDAO.relatorioOcupacaoHoje();
        
        System.out.println(">> Quartos Ocupados Hoje: " + quantidade);
        
      
    

    }  
}
