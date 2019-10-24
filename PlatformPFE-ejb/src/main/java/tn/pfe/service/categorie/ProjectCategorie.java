package tn.pfe.service.categorie;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.Student;

/**
 * Session Bean implementation class ProjectCategorie
 */
@Stateless
@LocalBean
public class ProjectCategorie implements ProjectCategorieRemote, ProjectCategorieLocal {

	@PersistenceContext(unitName="PlateformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProjectCategorie() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Object> getNbStageParCategorie() {
		// TODO Auto-generated method stub
		List<Object> stages = em.createQuery("Select COUNT(s) as nb from GradProject_File s , project_Categoy c where c.ID_projectCategory = s.ID_gradproject group by c.ID_projectCategory", Object.class).getResultList();
		return stages;
	}
    
    

}
