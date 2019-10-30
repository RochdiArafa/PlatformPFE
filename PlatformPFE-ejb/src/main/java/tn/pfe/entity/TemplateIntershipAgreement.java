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
public class TemplateIntershipAgreement implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Template;
	
	@OneToMany(mappedBy="templateIntershipAgreement" , fetch=FetchType.EAGER)
	private List<InternshipAgreement> internshipAgreement;
	
	
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
	public TemplateIntershipAgreement(int id, String template, List<InternshipAgreement> internshipAgreement) {
		this.id = id;
		Template = template;
		this.internshipAgreement = internshipAgreement;
	}
	public List<InternshipAgreement> getInternshipAgreement() {
		return internshipAgreement;
	}
	public void setInternshipAgreement(List<InternshipAgreement> internshipAgreement) {
		this.internshipAgreement = internshipAgreement;
	}
	
	
	
	
	
	
	

}
