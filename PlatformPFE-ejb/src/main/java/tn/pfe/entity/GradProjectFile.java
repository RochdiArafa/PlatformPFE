package tn.pfe.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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



@Entity
@Table(name="GradProject_File")
public class GradProjectFile implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_gradproject")
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

	@OneToOne(mappedBy="gradproj" , fetch=FetchType.EAGER)
	private Company company;
	
	@ManyToOne
	private TemplatePFE templatePFE;
	
	@ManyToMany(mappedBy="gradProjectFiles" , fetch=FetchType.EAGER)
	private List<projectCategory> Categorys = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public List<projectCategory> getCategorys() {
		return Categorys;
	}

	public void setCategorys(List<projectCategory> categorys) {
		Categorys = categorys;
	}

	public GradProjectFile(int id, String title, String description, String problem, String functionnalities,
			String keyword, Company company, TemplatePFE templatePFE, List<projectCategory> categorys) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.problem = problem;
		this.functionnalities = functionnalities;
		this.keyword = keyword;
		this.company = company;
		this.templatePFE = templatePFE;
		Categorys = categorys;
	}

	public GradProjectFile() {
	}

	@Override
	public String toString() {
		return "GradProjectFile [id=" + id + ", title=" + title + ", description=" + description + ", problem="
				+ problem + ", functionnalities=" + functionnalities + ", keyword=" + keyword + ", company=" + company
				+ ", templatePFE=" + templatePFE + ", Categorys=" + Categorys + "]";
	}


	
	



	
	
	
	

}
