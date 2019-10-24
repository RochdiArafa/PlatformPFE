package tn.pfe.service.categorie;


import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ProjectCategorieRemote {

	public List<Object> getNbStageParCategorie();
}
