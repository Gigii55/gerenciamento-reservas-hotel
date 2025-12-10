package services;

import dao.AtendenteDAO;
import model.Atendente;

public class LoginService {

	AtendenteDAO atendenteDAO = new AtendenteDAO();
   
    public Atendente fazerLogin(String email, String senhaDigitada) {
     
        Atendente atendente = atendenteDAO.buscarPorEmail(email);

        if (atendente == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }

        if (!atendente.getSenha().equals(senhaDigitada)) {
        	
            System.out.println("Senha incorreta.");
            return null;
        }

        System.out.println("Login realizado com sucesso! Bem-vindo, " + atendente.getNome());
        return atendente;
    }
}

