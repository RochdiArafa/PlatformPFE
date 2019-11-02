package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.*;

@Local
public interface CategorieServiceLocal {
	List<projectCategory> getCategories();
	int addCategorie(projectCategory c);
	void deleteCategorieById(int idC);
	void updateCtegorie(projectCategory c);
	void affecterCategorieToTeacher(int idC, int idT);
	void affecterCategoriePrefereToTeacher(int idC, int idT);
    void deletepreferedCategori(int idt, int idc);
	
}
