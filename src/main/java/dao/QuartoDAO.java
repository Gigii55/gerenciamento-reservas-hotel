package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QuartoDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	
	
}
