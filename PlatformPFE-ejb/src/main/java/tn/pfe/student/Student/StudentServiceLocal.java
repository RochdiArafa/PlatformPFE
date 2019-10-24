package tn.pfe.student.Student;


import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Student;

@Local
public interface StudentServiceLocal {
	public List<Student> getAllStudent();
	public List<Student> getAllStudentRecrutedoverContry();
	public List<Student> getAllStudentRecrutedByContryByYear(String contry , String year);

}
