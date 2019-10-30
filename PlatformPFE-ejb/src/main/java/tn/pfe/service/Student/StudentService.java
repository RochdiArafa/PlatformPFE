package tn.pfe.service.Student;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.pfe.entity.CoachCompany;
import tn.pfe.entity.SendEmail;
import tn.pfe.entity.Student;
import tn.pfe.entity.User;

/**
 * Session Bean implementation class StudentService
 */
@Stateless
@LocalBean
public class StudentService implements StudentServiceRemote, StudentServiceLocal {

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public StudentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Student> getAllStudent(){
		// TODO Auto-generated method stub
		List<Student> Students = em.createQuery("Select s from Student s", Student.class).getResultList();
		return Students;
	}
	
	@Override
	public List<Student> getAllStudentRecrutedoverContry() {
		// TODO Auto-generated method stub
		List<Student> Students = em.createQuery("Select s from Student s , Company c where c.country Not like 'tunisia' AND c.id = s.company.id", Student.class).getResultList();
		return Students;
	} 

	@Override
	public List<Student> getAllStudentRecrutedByContryByYear(String contry, int year) {
		// TODO Auto-generated method stub
		List<Student> Students ;
		Query query =  em.createQuery("Select s from Student s , Company c  , InternshipAgreement ia where c.country like :contry and extract(year from ia.beginningDate) like :year and c.id = s.company.id and c.internagreement.id = ia.id ").setParameter("contry", contry).setParameter("year", year);
		Students = query.getResultList();
		return Students;
	}

	@Override
	public void ajouterEncadrent(String EmailRecip) {
		// TODO Auto-generated method stub
		String password ="";
		CoachCompany encadreur = new CoachCompany(EmailRecip, "");
		String subject ;
		subject = "Bonjour Monsieur ,Bonjour  Madame votre mode de passe pour connecter à notre plateforme de stage PFE est "+password;
		 
		SendEmail email = new SendEmail();
		//email.generateAndSendEmail(EmailRecip, subject, GmailId, GmailPassword);
	}

}
