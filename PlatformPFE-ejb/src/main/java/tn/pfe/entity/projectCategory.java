package tn.pfe.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.itextpdf.tool.xml.html.head.Title;

import tn.pfe.entity.Teacher;

@Entity
@Table
@XmlRootElement
public class projectCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_projectCategory")
	private int id;
		
	private String Name;
	
	private String Description;

	private Boolean valide;
	
	@ManyToMany(mappedBy = "PreferedCategories" , cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Teacher> teacherspreferdCategorie = new HashSet<>();

	
	@ManyToOne
	private Teacher Teacher;
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<GradProjectFile> gradProjectFiles;
	
	
	
	
	
	
	
	
	@XmlTransient
	public Set<Teacher> getTeacherpreferdCategories() {
		return teacherspreferdCategorie;
	}

	public void setTeacherspreferdCategorie(Set<Teacher> teachers) {
		this.teacherspreferdCategorie = teachers;
	}

	
	
	
	public projectCategory(String name) {
		super();
		//this.name = name;
	}
	
	public projectCategory(){}
	

	@XmlTransient
	public List<GradProjectFile> getGradProjectFiles() {
		return gradProjectFiles;
	}

	public void setGradProjectFiles(List<GradProjectFile> gradProjectFiles) {
		this.gradProjectFiles = gradProjectFiles;
	}

	
	public projectCategory(int id, String name, List<GradProjectFile> gradProjectFiles) {
		this.id = id;
		this.Name = name;
		this.gradProjectFiles = gradProjectFiles;
	}


	

	@XmlTransient
	public Teacher getTeacher() {
		return Teacher;
	}

	public void setTeacher(Teacher teacher) {
		Teacher = teacher;
	}

	

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@XmlElement
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	
    @XmlElement
	public Boolean getValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}

	@XmlTransient
	public Set<Teacher> getTeacherspreferdCategorie() {
		return teacherspreferdCategorie;
	}
	

	@Override
	public String toString() {
		return ""+id+" , "+Name;
	}

	
	


	
	
	
}
