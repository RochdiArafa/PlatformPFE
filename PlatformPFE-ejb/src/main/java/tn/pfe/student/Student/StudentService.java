package tn.pfe.student.Student;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.pfe.entity.Student;

/**
 * Session Bean implementation class StudentService
 */
@Stateless
@LocalBean
public class StudentService implements StudentServiceRemote, StudentServiceLocal {

	@PersistenceContext(unitName="PlateformPFEDS")
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
		List<Student> Students = em.createQuery("Select s from Student s , Company c where c.country not like 'tunisia' AND c.id = s.id", Student.class).getResultList();
		return Students;
	}

	@Override
	public List<Student> getAllStudentRecrutedByContryByYear(String contry, String year) {
		// TODO Auto-generated method stub
		List<Student> Students ;
		Query query =  em.createQuery("Select s from Student s , Company c where c.country=:contry AND c.year =:year AND c.id = s.id").setParameter(1, contry).setParameter(2, year);
		Students = query.getResultList();
		return Students;
	}

}
