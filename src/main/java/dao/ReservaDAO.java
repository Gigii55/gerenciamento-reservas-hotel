package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservaDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");


}