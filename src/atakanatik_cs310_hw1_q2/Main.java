package atakanatik_cs310_hw1_q2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs310_hw1_2");
		EntityManager manager = emf.createEntityManager();
		
		AtakanJpaManager jpaManager = new AtakanJpaManager(manager);
		//jpaManager.readFromFile("world.txt");
		//jpaManager.writeIntoTable(jpaManager.getCountryList());
		//System.out.println(jpaManager.getCountryById(10).getDomain());
		//jpaManager.deleteCountryById(10);
		jpaManager.updateCountryPopulationById(11, 20);
	}

}
