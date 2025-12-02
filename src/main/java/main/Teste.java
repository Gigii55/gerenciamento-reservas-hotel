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
import model.Hospede;
import model.Quarto;
import model.Status;
import model.Tipo;



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
        
        
     
     
        List<Quarto> todosQuartos = quartoDAO.listarTodos();

        for (Quarto q : todosQuartos) {
            System.out.println("ID: " + q.getId() + 
                               " | Nº: " + q.getNumeroQuarto() + 
                               " | Tipo: " + q.getTipoQuarto() + 
                               " | R$: " + q.getValorDiaria());
        }
        
    }
}
