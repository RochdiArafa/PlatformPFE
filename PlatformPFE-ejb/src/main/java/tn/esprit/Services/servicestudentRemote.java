package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.*;


@Remote
public interface servicestudentRemote {
	public String addstudent(Student s);
	public void affecter_A_toS(int id_stduent, int id_admin);
	public List<Student> affStudent();
	public void deleteStudentbyid(int ids);
	public void updateSrudent(Student s );
	public 	List<Teacher>getencadrant();
	public void notifencadrant();
	public List<GradProjectFile> getpfe();
	public List<Teacher>getrapporteur();
	public void notifrapporteur();
	public List <GradProjectFile> pfe_v_E_R();
	public void notifchefdepartement();
	public List<GradProjectFile> PFEvalide(List<GradProjectFile> pfes);



}
