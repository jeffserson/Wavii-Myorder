package br.com.wavii.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("Myorder");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}