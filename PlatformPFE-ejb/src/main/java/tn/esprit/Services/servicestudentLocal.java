package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.*;


@Local
public interface servicestudentLocal {
	public String addstudent(Student s);
	public void affecter_A_toS(int id_stduent, int id_admin);
	public List<Student> affStudent();
	public void deleteStudentbyid(int ids);
	public void updateSrudent(Student s );
	public 	List<Teacher>getencadrant();
	public void notifencadrant();
	public void notifrapporteur();
	public List<GradProjectFile> getpfe();
	public List<Teacher>getrapporteur();
	public List <GradProjectFile> pfe_v_E_R();
	public void notifchefdepartement();
	public List<GradProjectFile> PFEvalide(List<GradProjectFile> pfe);
	

}
