package tn.pfe.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TemplateIntershipAgreement implements Serializable {
	
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
	
	
	
	
	public TemplateIntershipAgreement(String template) {
		Template = template;
	}
	public TemplateIntershipAgreement(int id, String template) {
		this.id = id;
		Template = template;
	}
	public TemplateIntershipAgreement() {
	}
	
	
	@Override
	public String toString() {
		return "TemplatePFE [id=" + id + ", Template=" + Template + "]";
	}
	
	
	
	
	
	
	

}
