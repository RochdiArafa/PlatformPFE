package tn.pfe.service.categorie;


import java.util.List;

import javax.ejb.Local;

@Local
public interface ProjectCategorieLocal {

	public List<Object> getNbStageParCategorie();

}
