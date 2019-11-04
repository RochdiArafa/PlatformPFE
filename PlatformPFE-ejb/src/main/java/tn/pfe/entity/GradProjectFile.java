package tn.pfe.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import tn.pfe.entity.Student;



@Entity
@Table(name="GradProject_File")
public class GradProjectFile implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="title_gradproject")
	private String title;
	@Column(name="description_gradproject")
	private String description;
	@Column(name="problem_gradproject")
	private String problem;
	@Column(name="functionnalities_gradproject")
	private String functionnalities;
	@Column(name="keyword_gradproject")
	private String keyword;

	
	
private String state;

private String stateRapport;
	
	private String anneeScolaire;
	
	@Temporal(TemporalType.DATE)
	private Date dateSaisie;
	
	private String Motif;
	
	private double noteEncadrant;
	
	private double noteRapporteur;

	@OneToOne(mappedBy = "PfeFile")
	private Student Student;
	
	
	
	@OneToOne(mappedBy="gradproj" , fetch=FetchType.EAGER)
	private Company company;
	
	@ManyToOne
	private TemplatePFE templatePFE;
	
	@ManyToMany(mappedBy="gradProjectFiles" , fetch=FetchType.EAGER)
	private Set<projectCategory> Categorys = new HashSet<>();

	private String pays;
	
	
	
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	@XmlElement
	public double getNoteEncadrant() {
		return noteEncadrant;
	}

	public void setNoteEncadrant(double noteEncadrant) {
		this.noteEncadrant = noteEncadrant;
	}

	public double getNoteRapporteur() {
		return noteRapporteur;
	}

	public void setNoteRapporteur(double noteRapporteur) {
		this.noteRapporteur = noteRapporteur;
	}

	@XmlElement
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	
	@XmlElement
	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	@XmlTransient
	public Student getStudent() {
		return Student;
	}

	public void setStudent(Student student) {
		Student = student;
	}

	

	@XmlElement
	public Set<projectCategory> getCategoriesoffile() {
		return Categorys;
	}

	public void setCategoriesoffile(Set<projectCategory> categoriesoffile) {
		this.Categorys= categoriesoffile;
	}

	@XmlElement
	public String getMotif() {
		return Motif;
	}

	public void setMotif(String motif) {
		Motif = motif;
	}
	
	
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getFunctionnalities() {
		return functionnalities;
	}

	public void setFunctionnalities(String functionnalities) {
		this.functionnalities = functionnalities;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public TemplatePFE getTemplatePFE() {
		return templatePFE;
	}

	public void setTemplatePFE(TemplatePFE templatePFE) {
		this.templatePFE = templatePFE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public Set<projectCategory> getCategorys() {
		return Categorys;
	}

	public void setCategorys(Set<projectCategory> categorys) {
		Categorys = categorys;
	}

	public GradProjectFile(int id, String title, String description, String problem, String functionnalities,
			String keyword, Company company, TemplatePFE templatePFE) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.problem = problem;
		this.functionnalities = functionnalities;
		this.keyword = keyword;
		this.company = company;
		this.templatePFE = templatePFE;
		//Categorys = categorys;
	}

	public GradProjectFile() {
	}

	
	
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "GradProjectFile [id=" + id + ", title=" + title + ", description=" + description + ", problem="
				+ problem + ", functionnalities=" + functionnalities + ", keyword=" + keyword + ", state=" + state
				+ ", stateRapport=" + stateRapport + ", anneeScolaire=" + anneeScolaire + ", dateSaisie=" + dateSaisie
				+ ", Motif=" + Motif + ", noteEncadrant=" + noteEncadrant + ", noteRapporteur=" + noteRapporteur
				+ ", Student=" + Student + ", company=" + company + ", templatePFE=" + templatePFE + ", Categorys="
				+ Categorys + ", pays=" + pays + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradProjectFile other = (GradProjectFile) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Date getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public String getStateRapport() {
		return stateRapport;
	}

	public void setStateRapport(String stateRapport) {
		this.stateRapport = stateRapport;
	}


	
	



	
	
	
	

}
