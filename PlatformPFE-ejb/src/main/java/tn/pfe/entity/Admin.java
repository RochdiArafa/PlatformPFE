package tn.pfe.entity;

public class Admin {

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Admin extends User implements Serializable {

	private String Element;
	
	
	@OneToMany(mappedBy = "admin")
	private List<Payment> payments = new ArrayList<Payment>();
	

	public String getElement() {
		return Element;
	}

	public void setElement(String element) {
		Element = element;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
}
