package main;

import dao.AtendenteDAO;
import dao.ComodidadesDAO;
import dao.FaturaDAO;
import dao.FaturaExtraDAO;
import dao.HospedeDAO;
import dao.IdiomaDAO;
import dao.PessoaDAO;
import dao.QuartoDAO;
import dao.ReservaDAO;



public class Teste {

    public static void main(String[] args) {

    	AtendenteDAO atendenteDAO = new AtendenteDAO();
        HospedeDAO hospede = new HospedeDAO();
        IdiomaDAO idiomaDAO = new IdiomaDAO();
        ComodidadesDAO comodidadesDAO = new ComodidadesDAO();
        QuartoDAO quartoDAO = new QuartoDAO();
        FaturaDAO faturaDAO = new FaturaDAO();
        FaturaExtraDAO faturaExtraDAO = new FaturaExtraDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
        PessoaDAO pessoa = new PessoaDAO();
       
        
    }
}