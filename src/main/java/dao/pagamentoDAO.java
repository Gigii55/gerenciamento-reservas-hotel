package dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class pagamentoDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");


}
