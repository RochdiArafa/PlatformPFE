package tn.pfe.service.Student;


import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Student;

@Remote
public interface StudentServiceRemote {

	public List<Student> getAllStudent();
	public List<Student> getAllStudentRecrutedoverContry();
	public List<Student> getAllStudentRecrutedByContryByYear(String contry , int year);


}
