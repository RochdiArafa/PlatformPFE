package tn.pfe.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import tn.pfe.entity.Student;



@Entity
@Table(name="GradProject_File")
@XmlRootElement(name ="GradProjectFile")
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

	
	
private boolean preValidated;
	
	@Temporal(TemporalType.DATE)
	private Date anneeScolaire =  new Date();
	
	private String Motif;
	
	private double note;
	
	private double note_rapporteur;

	@OneToOne(fetch=FetchType.EAGER)
	private Student Student;
	
	
	@OneToOne(mappedBy="pfe",cascade =CascadeType.MERGE,fetch=FetchType.EAGER)
	private Soutenance soutenance ;
	
	
	@OneToOne(mappedBy="gradproj" , fetch=FetchType.EAGER)
	private Company company;
	
	@ManyToOne
	private TemplatePFE templatePFE;
	
	@ManyToMany(mappedBy="gradProjectFiles" , fetch=FetchType.EAGER)
	private Set<projectCategory> Categorys = new HashSet<>();

	
	
	
	
	@XmlElement
	public Soutenance getSoutenance() {
		return soutenance;
	}

	public void setSoutenance(Soutenance soutenance) {
		this.soutenance = soutenance;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	@XmlElement
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@XmlElement
	public boolean isPreValidated() {
		return preValidated;
	}

	public void setPreValidated(boolean preValidated) {
		this.preValidated = preValidated;
	}

	
	@XmlElement
	public Date getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(Date anneeScolaire) {
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
	
	
	
	
	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
@XmlElement
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}
@XmlElement
	public String getFunctionnalities() {
		return functionnalities;
	}

	public void setFunctionnalities(String functionnalities) {
		this.functionnalities = functionnalities;
	}
@XmlElement
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

@XmlElement
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
@XmlElement
	public TemplatePFE getTemplatePFE() {
		return templatePFE;
	}

	public void setTemplatePFE(TemplatePFE templatePFE) {
		this.templatePFE = templatePFE;
	}
@XmlElement
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



@XmlTransient
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

	
	@Override
	public String toString() {
		return "GradProjectFile [id=" + id + ", title=" + title + ", description=" + description + ", problem="
				+ problem + ", functionnalities=" + functionnalities + ", keyword=" + keyword + ", company=" + company
				+ ", templatePFE=" + templatePFE + ", Categorys=" + Categorys + "]";
	}

	public double getNote_rapporteur() {
		return note_rapporteur;
	}

	public void setNote_rapporteur(double note_rapporteur) {
		this.note_rapporteur = note_rapporteur;
	}


	
	



	
	
	
	

}
