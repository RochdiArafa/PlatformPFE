package tn.pfe.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@XmlRootElement(name = "teacher")
public class Teacher  extends User  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String image;
	private String departement;

	@ManyToMany(fetch = FetchType.EAGER)//our l xml
	private Set<projectCategory> PreferedCategories = new HashSet<>();
	
	
	@OneToMany(mappedBy = "Teacher", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<projectCategory> categoriesProposed = new HashSet<>() ;
	

	@OneToMany(mappedBy = "teacher" , cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Section> Sections = new HashSet<>();
	
	
	@OneToMany(mappedBy = "Teacher" , cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Recomendation> Recomendations = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Skill> Skills = new HashSet<>();
	
	
	@OneToMany(mappedBy = "encadrants", cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Student> EtudiantAEncadrer = new HashSet<>();
	
	@OneToMany(mappedBy = "rapporteurs", cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Student> Etudiantarapporter = new HashSet<>();
	
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
	private Set<ActionTeacher> ActionsTeacher = new HashSet<>();
	
	
	
	@OneToMany(mappedBy = "president", fetch = FetchType.EAGER)
	private Set<Student> Etudiantsapresident = new HashSet<>();
	
	
	
	public void addCategorie(projectCategory c) {
		c.setTeacher(this);
		this.categoriesProposed.add(c);
	}
	
	
	@XmlTransient
	public Set<Student> getEtudiantAEncadrer() {
		return EtudiantAEncadrer;
	}



	public void setEtudiantAEncadrer(Set<Student> etudiantAEncadrer) {
		EtudiantAEncadrer = etudiantAEncadrer;
	}


	@XmlTransient
	public Set<Student> getEtudiantarapporter() {
		return Etudiantarapporter;
	}



	public void setEtudiantarapporter(Set<Student> etudiantarapporter) {
		Etudiantarapporter = etudiantarapporter;
	}



	@XmlTransient
	public Set<Skill> getSkills() {
		return Skills;
	}



	public void setSkills(Set<Skill> skills) {
		Skills = skills;
	}


	@XmlTransient
	public Set<Recomendation> getRecomendations() {
		return Recomendations;
	}



	public void setRecomendations(Set<Recomendation> recomendations) {
		Recomendations = recomendations;
	}


	/*@XmlElement
	@XmlElementWrapper*/
	@XmlTransient
	public Set<projectCategory> getCategoriesProposed() {
		return categoriesProposed;
	}



	public void setCategoriesProposed(Set<projectCategory> categoriesProposed) {
		this.categoriesProposed = categoriesProposed;
	}


	@XmlTransient
	public Set<Section> getSections() {
		return Sections;
	}



	public void setSections(Set<Section> sections) {
		Sections = sections;
	}


	/*@XmlElement
	@XmlElementWrapper*/
	@XmlTransient
	public Set<projectCategory> getPreferedCategories() {
		return PreferedCategories;
	}



	public void setPreferedCategories(Set<projectCategory> preferedCategories) {
		PreferedCategories = preferedCategories;
	}



	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
   @XmlElement
	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}


	@XmlElement
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@XmlTransient
	public Set<ActionTeacher> getActionsTeacher() {
		return ActionsTeacher;
	}


	public void setActionsTeacher(Set<ActionTeacher> actionsTeacher) {
		ActionsTeacher = actionsTeacher;
	}

	@XmlTransient
	public Set<Student> getEtudiantsapresident() {
		return Etudiantsapresident;
	}


	public void setEtudiantsapresident(Set<Student> etudiantsapresident) {
		Etudiantsapresident = etudiantsapresident;
	}

	

	
}
