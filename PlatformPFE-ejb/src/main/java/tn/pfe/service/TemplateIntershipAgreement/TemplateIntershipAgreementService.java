package tn.pfe.service.TemplateIntershipAgreement;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.TemplateIntershipAgreement;



@Stateless
public class TemplateIntershipAgreementService  implements TemplateIntershipAgreementServiceLocal , TemplateIntershipAgreementServiceRemote{

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;

	@Override
	public void ajouter(TemplateIntershipAgreement T) {
		// TODO Auto-generated method stub
		em.persist(T);
	}

	@Override
	public TemplateIntershipAgreement search(int id) {
		// TODO Auto-generated method stub
		return em.find(TemplateIntershipAgreement.class, id);
	}

	@Override
	public void modifier(TemplateIntershipAgreement T) {
		// TODO Auto-generated method stub
		em.merge(T);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(search(id));
	}
	
}
