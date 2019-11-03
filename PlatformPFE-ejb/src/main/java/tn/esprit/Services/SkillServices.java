package tn.esprit.Services;

import java.util.List;
import java.util.Set;

import javax.ejb.FinderException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class SkillServices
 */
@Stateless
@LocalBean
public class SkillServices implements SkillServicesRemote, SkillServicesLocal {

	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SkillServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addSkill(int idt,int idc, Skill comp) {
		em.persist(comp);
		Teacher t = em.find(Teacher.class, idt);
		Skill sk = em.find(Skill.class,comp.getId());
		projectCategory c = em.find(projectCategory.class, idc);
		
		sk.setCategorie(c);
		t.getSkills().add(sk);
		sk.getTeachers().add(t);
		return comp.getId();
	}

	@Override
	public Set<Skill> getTeacherSkills(int idt) {
		
		Teacher t = em.find(Teacher.class, idt);
		
		return t.getSkills();
	}

}
