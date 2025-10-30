package main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {

        System.out.println("Iniciando aplicação...");

        try {
            // ESTA LINHA "ACORDA" O JPA E FAZ ELE RODAR O HBM2DDL.AUTO
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU"); 

            // Se o programa chegou aqui sem erro, as tabelas foram criadas/atualizadas!
            System.out.println("JPA inicializado com sucesso!");
            System.out.println("Tabelas criadas ou atualizadas.");

            // Feche o factory para o programa poder terminar
            emf.close();
            System.out.println("Aplicação finalizada.");

        } catch (Exception e) {
            System.err.println("Erro ao inicializar o JPA:");
            e.printStackTrace(); // Isso mostrará qualquer erro (ex: senha errada, banco não existe)
        }
    }
}