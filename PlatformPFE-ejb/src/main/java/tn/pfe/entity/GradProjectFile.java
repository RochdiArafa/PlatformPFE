package tn.pfe.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int title;
	@Column(name="description_gradproject")
	private int description;
	@Column(name="problem_gradproject")
	private int problem;
	@Column(name="functionnalities_gradproject")
	private int functionnalities;
	@Column(name="keyword_gradproject")
	private int keyword;
	@OneToMany(mappedBy="GradProject_File")
	@Column(name="category_gradproject")
	List<projectCategory>category;
	@OneToOne(mappedBy="gradproj")
	private Company company;
	
	@ManyToOne
	private TemplatePFE templatePFE;

	public GradProjectFile(int title, int description, int problem, int functionnalities, int keyword,
			List<projectCategory> category, Company company) {
		super();
		this.title = title;
		this.description = description;
		this.problem = problem;
		this.functionnalities = functionnalities;
		this.keyword = keyword;
		this.category = category;
		this.company = company;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
	public int getProblem() {
		return problem;
	}
	public void setProblem(int problem) {
		this.problem = problem;
	}
	public int getFunctionnalities() {
		return functionnalities;
	}
	public void setFunctionnalities(int functionnalities) {
		this.functionnalities = functionnalities;
	}
	public int getKeyword() {
		return keyword;
	}
	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}
	
	public List<projectCategory> getCategory() {
		return category;
	}
	public void setCategory(List<projectCategory> category) {
		this.category = category;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public GradProjectFile(int id, int title, int description, int problem, int functionnalities, int keyword,
			List<projectCategory> category, Company company, TemplatePFE templatePFE) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.problem = problem;
		this.functionnalities = functionnalities;
		this.keyword = keyword;
		this.category = category;
		this.company = company;
		this.templatePFE = templatePFE;
	}
	
	
	

}
