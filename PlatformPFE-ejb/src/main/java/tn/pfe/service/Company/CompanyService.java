package tn.pfe.service.Company;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.Company;
import tn.pfe.entity.Student;

/**
 * Session Bean implementation class CompanyService
 */
@Stateless
@LocalBean
public class CompanyService implements CompanyServiceRemote, CompanyServiceLocal {

	@PersistenceContext(unitName="PlateformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CompanyService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Object> getRecrutedCompayByOrder() {
		// TODO Auto-generated method stub
		List<Object> Companys = em.createQuery("select c , COUNT(c.idEtreprise) AS nb from users u , Company c WHERE u.idEtreprise = c.id GROUP BY u.idEtreprise ORDER by nb DESC", Object.class).getResultList();
		return Companys;
	}

}
