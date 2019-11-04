package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import tn.pfe.entity.*;

@Entity
public class Student extends User implements Serializable{

	@ManyToOne
	private Company company;
	
	private int grade;

	@ManyToOne
	private Teacher encadrants ;
	
	@ManyToOne
	private Teacher  rapporteurs;
	
	
	@OneToOne
	private GradProjectFile PfeFile;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@XmlTransient
	public Teacher getEncadrants() {
		return encadrants;
	}


	
	public void setEncadrants(Teacher encadrants) {
		this.encadrants = encadrants;
	}


	@XmlTransient
	public Teacher getRapporteurs() {
		return rapporteurs;
	}



	public void setRapporteurs(Teacher rapporteurs) {
		this.rapporteurs = rapporteurs;
	}


	@XmlElement
	public GradProjectFile getPfeFile() {
		return PfeFile;
	}



	public void setPfeFile(GradProjectFile pfeFile) {
		PfeFile = pfeFile;
	}


	@XmlElement
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


	@XmlTransient
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
}
