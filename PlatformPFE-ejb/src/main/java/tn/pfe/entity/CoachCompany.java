package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CoachCompany extends User implements Serializable{

	@ManyToOne
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CoachCompany(String email, String password, Company company) {
		super(email, password);
		this.company = company;
	}
	
	public CoachCompany(String email, String password) {
		super(email, password);
	}
	
	
	
	
}
