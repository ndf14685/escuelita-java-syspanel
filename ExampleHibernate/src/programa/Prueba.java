package programa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tablas.Actor;
import utils.HibernateUtils;

public class Prueba {
	
	private static Session session;
	
	public static void main(String[] args) {
		session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		//CreateActor(2,"mariano");
		tx.commit();
		session.close();
		System.exit(0);
	}
	
	public static void CreateActor(int id, String nombre)
	{
		Actor ac = new Actor();
		session.save(ac);
	}

}
