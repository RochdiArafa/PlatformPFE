package tn.pfe.service.categorie;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Student;
import tn.pfe.entity.projectCategory;

/**
 * Session Bean implementation class ProjectCategorie
 */
@Stateless
@LocalBean
public class ProjectCategorie implements ProjectCategorieRemote, ProjectCategorieLocal {

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProjectCategorie() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<GradProjectFile> getNbStageParCategorie(int id_category) {
		projectCategory c = em.find(projectCategory.class, id_category);
		if(c != null) {

			List<GradProjectFile> stages = new ArrayList<GradProjectFile>();

			List<GradProjectFile> GradProjectFiles = em.createQuery("Select s from GradProjectFile s ", GradProjectFile.class).getResultList();
			for (GradProjectFile file : GradProjectFiles) {
				if(file.getCategorys().contains(c))
					stages.add(file);
			}
			
			return stages;
		}
		else
			return null;
	}
	
}	
    
    


