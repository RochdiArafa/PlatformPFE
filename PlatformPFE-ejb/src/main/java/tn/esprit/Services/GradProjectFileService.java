package tn.esprit.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.pfe.entity.GradProjectFile;

/**
 * Session Bean implementation class GradProjectFileService
 */
@Stateless
@LocalBean
public class GradProjectFileService implements GradProjectFileServiceRemote, GradProjectFileServiceLocal {

	@PersistenceContext
	public EntityManager em;
	
    public GradProjectFileService() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public GradProjectFile searchSheet(int id)
    {
    	return em.find(GradProjectFile.class, id);
    }
    @Override
    public List<GradProjectFile> getSheetsByEtat(String etat){
    	TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.state=:etat ", GradProjectFile.class);
    	query.setParameter("etat", etat);
		return query.getResultList();
    }

    @Override 
    public List<GradProjectFile> getSheetsByYear(String year){
    	TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.anneeScolairee=:year ", GradProjectFile.class);
    	query.setParameter("year", year);
		return query.getResultList();
    }
    @Override
    public List<GradProjectFile> getSheetsByPays(String pays){
    	TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.pays=:pays ", GradProjectFile.class);
    	query.setParameter("pays", pays);
		return query.getResultList();
    }
	@Override
	public List<GradProjectFile> getSheetsOfYear(){
		TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.state=:state AND f.anneeScolairee=:year ORDER BY f.dateSaisie DESC ", GradProjectFile.class);
    	query.setParameter("state", "encours");
    	query.setParameter("year", Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.YEAR)+1));
		return query.getResultList();
	}
	@Override
	public List<GradProjectFile> getWaitingDefense(){
		TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.note>:noteE AND f.note_rapporteur>:noteR ", GradProjectFile.class);
    	query.setParameter("noteE", 0);
    	query.setParameter("noteR", 0);
		return query.getResultList();
	}
}
