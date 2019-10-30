package tn.pfe.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TemplatePFE implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Template;
	
	@OneToMany(mappedBy="templatePFE" , fetch=FetchType.EAGER)
	private List<GradProjectFile> gradProjectFiles;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTemplate() {
		return Template;
	}
	public void setTemplate(String template) {
		Template = template;
	}
	
	
	
	public List<GradProjectFile> getGradProjectFiles() {
		return gradProjectFiles;
	}
	public void setGradProjectFiles(List<GradProjectFile> gradProjectFiles) {
		this.gradProjectFiles = gradProjectFiles;
	}
	public TemplatePFE(String template) {
		Template = template;
	}
	
	public TemplatePFE(int id, String template) {
		this.id = id;
		Template = template;
	}
	
	
	public TemplatePFE() {
	}
	
	
	
	@Override
	public String toString() {
		return "TemplatePFE [id=" + id + ", Template=" + Template + "]";
	}
	public TemplatePFE(int id, String template, List<GradProjectFile> gradProjectFiles) {
		this.id = id;
		Template = template;
		this.gradProjectFiles = gradProjectFiles;
	}
	
	
	
	
	
	
	
	
	

}
