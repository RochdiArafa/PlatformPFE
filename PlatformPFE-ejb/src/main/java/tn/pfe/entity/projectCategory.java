package tn.pfe.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_Categoy")
public class projectCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_projectCategory")
	private int id;
	@Column(name="name_projectCategory")
	private String name;
	
	
	@ManyToMany
	private List<GradProjectFile> gradProjectFiles;
	
	
	public projectCategory(String name) {
		super();
		this.name = name;
	}
	
	public projectCategory(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<GradProjectFile> getGradProjectFiles() {
		return gradProjectFiles;
	}

	public void setGradProjectFiles(List<GradProjectFile> gradProjectFiles) {
		this.gradProjectFiles = gradProjectFiles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public projectCategory(int id, String name, List<GradProjectFile> gradProjectFiles) {
		this.id = id;
		this.name = name;
		this.gradProjectFiles = gradProjectFiles;
	}


	



	
	
	
}
