package tn.esprit.Services;


import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.OldPfe;
import tn.pfe.entity.Student;

import javax.persistence.TypedQuery;

import tn.pfe.entity.GradProjectFile;


/**
 * Session Bean implementation class GradProjectFileService
 */
@Stateless
@LocalBean
public class GradProjectFileService implements GradProjectFileServiceRemote, GradProjectFileServiceLocal {


    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;


	
    public GradProjectFileService() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void addPfe(GradProjectFile pfe) {
    	em.persist(pfe);
    	
    }
    @Override
    public void deletepfe(int id) {
    	GradProjectFile ppPfe = new GradProjectFile();
    	OldPfe oPfe = new OldPfe();
		oPfe.setMotif(ppPfe.getMotif());
		Date datemodi = new Date();		
		oPfe.setDatemodif(datemodi);
		oPfe.setEvent("deleted");
		Student ssStudent = new Student();
		if(ppPfe.getStudent()!=null) {
		ssStudent.setLastName(ppPfe.getStudent().getLastName());
		ssStudent.setFirstName(ppPfe.getStudent().getFirstName());
		oPfe.setEmetteur(ssStudent.getFirstName()+ssStudent.getLastName());
		
		em.persist(oPfe);
    	em.remove(em.find(GradProjectFile.class, id));}
		else {
			em.remove(em.find(GradProjectFile.class, id));
		}
    	
    }
    @Override
    public List<GradProjectFile> GetPfe() {
    	return (List<GradProjectFile>) em.createQuery(" select c from GradProjectFile c where c.validated = 1 ",GradProjectFile.class).getResultList();
    }
    @Override
    public List<GradProjectFile> GetPfeValidated() {
    	// TODO Auto-generated method stub
    	return null;
    }
    @Override
    public void updatepfe(GradProjectFile pfe, int id) {
    	// System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*"+pfe.getMotif()+"/*//*/*/*/*"+id);
    	GradProjectFile ppPfe = em.find(GradProjectFile.class, id);
    	if(ppPfe != null) {
    		System.out.println("ahla");
    	OldPfe oPfe = new OldPfe();
		oPfe.setMotif(ppPfe.getMotif());
		Date datemodi = new Date();		
		oPfe.setDatemodif(datemodi);
		oPfe.setEvent("modification");
		oPfe.setDescription(pfe.getDescription());
		if(pfe.getEncadreur() != null) {
		oPfe.setEncadreur(pfe.getEncadreur());}
		if(pfe.getStudent() != null) {
		oPfe.setEmetteur(ppPfe.getStudent().getFirstName()+""+ppPfe.getStudent().getLastName());	}	
		em.persist(oPfe);
		ppPfe.setMotif(ppPfe.getMotif());
		ppPfe.setNote(pfe.getNote());
		ppPfe.setNote_rapporteur(pfe.getNote_rapporteur());
		ppPfe.setDescription(pfe.getDescription());
		
    }else {
    	System.out.println("non trouvé");
    	System.out.println(id);
    }
    	
    }
    


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
