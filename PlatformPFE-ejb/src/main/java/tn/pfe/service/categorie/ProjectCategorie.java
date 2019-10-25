package tn.pfe.service.categorie;


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
		// TODO Auto-generated method stub
		//List<Object> stages = em.createQuery("Select COUNT(*) as nb from GradProject_File s , project_Categoy c where  c.ID_projectCategory =:id_category", Object.class).setParameter("id_category", id_category).getResultList();
		List<GradProjectFile> stages = c.getGradProjectFiles();
		for (GradProjectFile g : stages) {
			System.out.println(g);
			
		}
		return stages;
	}
	
}	
    
    


