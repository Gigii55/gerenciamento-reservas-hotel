package main;

import dao.HospedeDAO;
import dao.PessoaDAO;
import model.Hospede;


public class Teste {

    public static void main(String[] args) {

       
        HospedeDAO hospede = new HospedeDAO();
        Hospede NH = new Hospede();
        NH.setCpf("2131323123");
       
        hospede.inserirNovaPessoa(NH);
     
        
    }
}