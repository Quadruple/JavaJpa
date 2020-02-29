package atakanatik_cs310_hw1_q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;

public class AtakanJpaManager {
	
	private ArrayList<Country> countryDataList;
	private EntityManager manager;
	
	public AtakanJpaManager(EntityManager manager)
	{
		super();
		countryDataList = new ArrayList<Country>();
		this.manager = manager;
	}
	

	public void readFromFile(String filename)
	{
		try
		{
			File worldData = new File(filename);
			Scanner dataReader = new Scanner(worldData);
			
			while(dataReader.hasNextLine())
			{
				String data = dataReader.nextLine();
				String[] extractedData = data.split(",");
				Country country = new Country(extractedData[0], extractedData[1], extractedData[2], extractedData[3]);
				countryDataList.add(country);
			}
			dataReader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Specified file not found.");
			e.printStackTrace();
		}
	}
	
	public void writeIntoTable(ArrayList<Country> countries)
	{
		for(Country country : countries)
		{
			try
			{
				if(!manager.getTransaction().isActive())
				{
					manager.getTransaction().begin();
				}
				manager.persist(country);
				manager.getTransaction().commit();
				
				System.out.println("Insertion successful.");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public Country getCountryById(int countryId)
	{
		try
		{
			Country result = manager.find(Country.class, countryId);
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteCountryById(int countryId)
	{
		try
		{
			Country toDelete = manager.find(Country.class, countryId);
			manager.getTransaction().begin();
			manager.remove(toDelete);
			manager.getTransaction().commit();
			System.out.println("Deletion successful.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateCountryPopulationById(int countryId, int population)
	{
		try
		{
			Country toUpdate = manager.find(Country.class, countryId);
			manager.getTransaction().begin();
			toUpdate.setPopulation(Integer.toString(population));
			manager.getTransaction().commit();
			System.out.println("Update successful.");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Country> getCountryList()
	{
		return countryDataList;
	}
}

















