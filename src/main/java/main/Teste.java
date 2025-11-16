package main;

import dao.AtendenteDAO;

public class Teste {

    public static void main(String[] args) {

   AtendenteDAO dao = new AtendenteDAO();
   dao.inserirAtendente("Maria", "123.456.789.-09", "44 991234567", "Maria@gmail.com");
        
    }
}