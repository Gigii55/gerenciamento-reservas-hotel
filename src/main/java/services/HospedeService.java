package services;


import java.util.Date;
import dao.HospedeDAO;
import model.Hospede;

public class HospedeService {

    private HospedeDAO hospedeDAO = new HospedeDAO();

    public void cadastrarHospede(Hospede novoHospede) {
        
    
        if (hospedeDAO.existeCpf(novoHospede.getCpf())) {
            System.out.println("Já existe um hóspede cadastrado com o CPF " + novoHospede.getCpf());
            return; 
        }

        if (!isMaiorDeIdade(novoHospede.getDataNascimento())) {
            System.out.println("Cadastro negado. O hóspede é menor de 18 anos.");
            return;
        }

        
        hospedeDAO.adicionar(novoHospede);
        System.out.println("SUCESSO: Hóspede " + novoHospede.getNome() + " cadastrado!");
    }

  
    private boolean isMaiorDeIdade(Date dataNasc) {
    	
        if (dataNasc == null) return false;

        Date hoje = new Date(); 

        int idade = hoje.getYear() - dataNasc.getYear();

     
        if (hoje.getMonth() < dataNasc.getMonth()) {
            idade--; 
        } 
       
        else if (hoje.getMonth() == dataNasc.getMonth() && hoje.getDate() < dataNasc.getDate()) {
            idade--; 
        }
        
        if (idade >= 18) {
            return true;
        } else {
            return false;
        }
}
}