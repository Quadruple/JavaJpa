package atakanatik_cs310_hw1_q2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "countryid")
	private int countryId = 0;
	
	@Column(name = "domain")
	private String domain = "";
	
	@Column(name = "region")
	private String region = "";
	
	@Column(name = "capital")
	private String capitalCity = "";
	
	@Column(name = "population")
	private String population = "";
	
	public Country()
	{
		super();
	}
	
	public Country(String domain, String region, String capitalCity, String population)
	{
		super();
		this.domain = domain;
		this.region = region;
		this.capitalCity = capitalCity;
		this.population = population;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}
}
