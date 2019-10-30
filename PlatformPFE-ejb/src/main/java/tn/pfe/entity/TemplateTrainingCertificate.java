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
public class TemplateTrainingCertificate implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Template;
	
	
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
	
	
	public TemplateTrainingCertificate(String template) {
		Template = template;
	}
	
	public TemplateTrainingCertificate(int id, String template) {
		this.id = id;
		Template = template;
	}
	
	
	public TemplateTrainingCertificate() {
	}
	
	
	
	@Override
	public String toString() {
		return "TemplatePFE [id=" + id + ", Template=" + Template + "]";
	}
		
	
	
	
	
	
	
	
	

}
