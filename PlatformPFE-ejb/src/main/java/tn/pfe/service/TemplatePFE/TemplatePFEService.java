package tn.pfe.service.TemplatePFE;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.TemplatePFE;


@Stateless
public class TemplatePFEService  implements TemplatePFEServiceLocal , TemplatePFEServiceRemote{

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;

	@Override
	public void ajouter(TemplatePFE T) {
		// TODO Auto-generated method stub
		em.persist(T);
	}

	@Override
	public TemplatePFE search(int id) {
		// TODO Auto-generated method stub
		return em.find(TemplatePFE.class, id);
	}

	@Override
	public void modifier(TemplatePFE T) {
		// TODO Auto-generated method stub
		em.merge(T);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(search(id));
	}
	
}
