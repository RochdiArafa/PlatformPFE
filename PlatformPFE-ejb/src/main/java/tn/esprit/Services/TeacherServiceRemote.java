package tn.esprit.Services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Remote;

import tn.pfe.entity.*;

@Remote
public interface TeacherServiceRemote {
	int addTeacher(Teacher t);
	List<Teacher>  getTeachers();
	void deleteTeacherById(int id);
	boolean updateTeacherById(Teacher t);
	Teacher getTeacherById(int id);
	void encadrerEtudiant(int idT,int idStu);
	Set<Student> listerSdtEncadre(int idT);
	Set<GradProjectFile> listerFileEncadrer(int idt);
	Set<GradProjectFile> listerFileRapporter(int idt);
	Set<Student> listerSdtarapporter(int idT);
	void prevalide(int idt,int idfile);
	void noterpfeFile(int idt,int idfile,double note);
	void rappporterEtudiant(int idT, int idStu);
	
	//stat
	List<GradProjectFile> getFilesencadredByYear(int idt, int year);
	List<GradProjectFile> getFilesencadredBetween2Years(int idt, int year1, int year2);
	List<GradProjectFile> getFilesrapportedByYear(int idt, int year);
	List<GradProjectFile> getFilesrapportedBetween2Years(int idt, int year1, int year2);
	Map<projectCategory, Integer> getmostencadredCategorie(int idt);
	Map<GradProjectFile, Double> getFileMostNote(int idt);
	Map<projectCategory, Double> getcategorieMostNote(int idt);
	//auto complete
		Map<projectCategory, Double> autoCompletePreferdCategorie(int idt);
	
	//extra
		void addEmploye(Student s);
		void addpfe(GradProjectFile e);
}
