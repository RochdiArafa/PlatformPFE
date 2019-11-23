package tn.esprit.Services;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.rmi.CORBA.Stub;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class TeacherService
 */

@Stateless
@LocalBean
public class TeacherService implements TeacherServiceRemote, TeacherServiceLocal {

	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
	
	
	@EJB
	CategorieService categorieser;
	
	@EJB
	ActionTeacherServices ActionService;
	
    /**
     * Default constructor. 
     */
    public TeacherService() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public int addTeacher(Teacher t) {
		 em.persist(t);
		 return t.getId();
				}
	
	
	@Override
	public List<Teacher> getTeachers() {
		
		return (List<Teacher>) em.createQuery("select t from  Teacher t",Teacher.class).getResultList();
	}


	@Override
	public void deleteTeacherById(int id) {
		Teacher t = em.find(Teacher.class, id);
		em.remove(t);
	}


	@Override
	public boolean updateTeacherById(Teacher t) {
		if(em.find(Teacher.class, t.getId()) != null) {
		
		Teacher teach = em.find(Teacher.class, t.getId());
		
		//teach.setAddress("");
		teach.setDepartement(t.getDepartement());
		teach.setImage(t.getImage());
		teach.setFirstName(t.getFirstName());
		teach.setPassword(t.getPassword());
		teach.setLastName(t.getLastName());
		//teach.set(t.getAddress());
           Timestamp time = new Timestamp(System.currentTimeMillis());
		
		ActionTeacher action = new ActionTeacher("Modificatin De Profil"," Vous avez modifier votre profil le "+time,null);
		ActionService.ajouterteacherAction(t.getId(), action);
			//em.merge(t);
		return true ;
	}
		return false;
	}


	@Override
	public Teacher getTeacherById(int id) {
		return em.find(Teacher.class, id);
	}

	
	
	//// teacher with student

	@Override
	public void encadrerEtudiant(int idT, int idStu) {
		// TODO Auto-generated method stub
		Teacher t  = em.find(Teacher.class, idT);
		Student s = em.find(Student.class, idStu);
		
		t.getEtudiantAEncadrer().add(s);
		s.setEncadrants(t);
		
	}


	@Override
	public Set<Student> listerSdtEncadre(int idT) {
		Teacher t  = em.find(Teacher.class, idT);
		return t.getEtudiantAEncadrer();
	}


	@Override
	public void addEmploye(Student s) {
	
		em.persist(s);
		
	}


	@Override
	public Set<GradProjectFile> listerFileEncadrer(int idt) {
		
		Set<Student> setStudent = new HashSet<>();
		
		setStudent = listerSdtEncadre(idt);
		Set<GradProjectFile> files = new HashSet<>() ;
		for(Student s :setStudent) {
			
			if(s.getPfeFile() != null) {
			
			files.add(s.getPfeFile());
			}
		}
		return files;
	}


	
	@Override
	public Set<GradProjectFile> listerFilePresedent(int idt) {
	Set<Student> setStudent = new HashSet<>();
		
		setStudent = listerSdtpresedent(idt);
		Set<GradProjectFile> files = new HashSet<>() ;
		for(Student s : setStudent) {
			
			if(s.getPfeFile() != null) {
			
			files.add(s.getPfeFile());
			}
		}
		return files;
	}
	
	
	
	
	
	//extra
	
	@Override
	public void addpfe(GradProjectFile f) {
		
		em.persist(f);
	}


	@Override
	public void prevalide(int idt, int idfile,String role) {
		
		Set<GradProjectFile> pfefiles ;
		if(role.equals("encadrant")) {
pfefiles = listerFileEncadrer(idt);
		}
		else if(role.equals("presedent")) {
			pfefiles = listerFilePresedent(idt);
		}
		else {
			 pfefiles = listerFileRapporter(idt);
		}
		
		for( GradProjectFile file : pfefiles ) {
			if(file != null) {
			if(file.getId() == idfile) {
				file.setPreValidated(true);
				
				// Action
				Timestamp time = new Timestamp(System.currentTimeMillis());
					
					ActionTeacher action = new ActionTeacher("Pre-validation d' une fiche pfe"," vous avez prevalider la fiche de"
							+file.getStudent().getFirstName()+"  "+file.getStudent().getFirstName()+ " en ttq "+role+" le "+time,null);
					ActionService.ajouterteacherAction(idt, action);
				
			}
			}
		}
		
	}


	@Override
	public void noterpfeFile(int idt, int idfile, double note, String Role) {
		
		Set<GradProjectFile> pfefiles ;
		if(Role.equals("encadrant")) {
pfefiles = listerFileEncadrer(idt);
		}
		else if(Role.equals("presedent")) {
			pfefiles = listerFilePresedent(idt);
		}
		else {
			 pfefiles = listerFileRapporter(idt);
		}
		for( GradProjectFile file : pfefiles ) {
			if(file != null) {
			if(file.getId() == idfile) {
				file.setNote(note);
				
				//action
				Timestamp time = new Timestamp(System.currentTimeMillis());
				
				ActionTeacher action = new ActionTeacher("Noter une fiche pfe"," vous avez attribuer une note a la fiche de"
						+file.getStudent().getFirstName()+"  "+file.getStudent().getFirstName()+ " en ttq "+Role+" le "+time,null);
				ActionService.ajouterteacherAction(idt, action);
				
				
			}
			}
		}
		
		
	}


	@Override
	public void rappporterEtudiant(int idT, int idStu) {
		
		// TODO Auto-generated method stub
				Teacher t  = em.find(Teacher.class, idT);
				Student s = em.find(Student.class, idStu);
				
				t.getEtudiantarapporter().add(s);
				s.setEncadrants(t);
		
	}


	@Override
	public Set<Student> listerSdtarapporter(int idT) {
		Teacher t  = em.find(Teacher.class, idT);
		return t.getEtudiantarapporter();
	}
	
	
	@Override
	public Set<Student> listerSdtpresedent(int idT) {
		Teacher t  = em.find(Teacher.class, idT);
		return t.getEtudiantsapresident();
	}
	
	
	
	
	

	@Override
	public Set<GradProjectFile> listerFileRapporter(int idt) {
Set<Student> setStudent = new HashSet<>();
		
		setStudent = listerSdtarapporter(idt);
		Set<GradProjectFile> files = new HashSet<>() ;
		for(Student s :setStudent) {
			
			if(s.getPfeFile() != null) {
			
			files.add(s.getPfeFile());
			}
		}
		return files;
	}
	
	
	
	
	
	
	

	@Override
	public List<GradProjectFile> getFilesencadredByYear(int idt, int year) {
		
		Set<GradProjectFile> listfiles = listerFileEncadrer(idt);
		List<GradProjectFile> listfileByYear= new ArrayList<GradProjectFile>();
		//SimpleDateFormat df = 	new SimpleDateFormat("dd/MM/yyyy");
		
	
		
		
			for( GradProjectFile file : listfiles ) {
		
			if(file != null) {
		
			
		  if(((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) == year) {
			  listfileByYear.add(file);
		  }
			}
		}
		
		return listfileByYear;
		
	}


	@Override
	public List<GradProjectFile> getFilesencadredBetween2Years(int idt, int year1, int year2) {

		Set<GradProjectFile> listfiles = listerFileEncadrer(idt);
		List<GradProjectFile> listfileBetwwen2Years= new ArrayList<GradProjectFile>();
		//SimpleDateFormat df = 	new SimpleDateFormat("dd/MM/yyyy");
		
	
		
		
			for( GradProjectFile file : listfiles ) {
		
			if(file != null) {
		
			
		  if(((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) >= year1 
				 &&  ((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) <= year2) {
			  listfileBetwwen2Years.add(file);
		  }
			}
		}
		
		return listfileBetwwen2Years;
	}


	@Override
	public List<GradProjectFile> getFilesrapportedByYear(int idt, int year) {
		Set<GradProjectFile> listfiles = listerFileRapporter(idt);
		List<GradProjectFile> listfileByYear= new ArrayList<GradProjectFile>();
		//SimpleDateFormat df = 	new SimpleDateFormat("dd/MM/yyyy");
		
	
		
		
			for( GradProjectFile file : listfiles ) {
		
			if(file != null) {
		
			
		  if(((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) == year) {
			  listfileByYear.add(file);
		  }
			}
		}
		
		return listfileByYear;
		
	}


	@Override
	public List<GradProjectFile> getFilesrapportedBetween2Years(int idt, int year1, int year2) {

		Set<GradProjectFile> listfiles = listerFileRapporter(idt);
		List<GradProjectFile> listfileBetwwen2Years= new ArrayList<GradProjectFile>();
		//SimpleDateFormat df = 	new SimpleDateFormat("dd/MM/yyyy");
		
	
		
		
			for( GradProjectFile file : listfiles ) {
		
			if(file != null) {
		
			
		  if(((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) >= year1 
				 &&  ((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) <= year2) {
			  listfileBetwwen2Years.add(file);
		  }
			}
		}
		
		return listfileBetwwen2Years;
	}

	
	
	
	
	
	@Override
	public List<GradProjectFile> getFilespresendentdByYear(int idt, int year) {
		Set<GradProjectFile> listfiles = listerFilePresedent(idt);
		List<GradProjectFile> listfileByYear= new ArrayList<GradProjectFile>();
		//SimpleDateFormat df = 	new SimpleDateFormat("dd/MM/yyyy");
		
	
		
		
			for( GradProjectFile file : listfiles ) {
		
			if(file != null) {
		
			
		  if(((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) == year) {
			  listfileByYear.add(file);
		  }
			}
		}
		
		return listfileByYear;
		
	}


	@Override
	public List<GradProjectFile> getFilespresedentBetween2Years(int idt, int year1, int year2) {
		Set<GradProjectFile> listfiles = listerFilePresedent(idt);
		List<GradProjectFile> listfileBetwwen2Years= new ArrayList<GradProjectFile>();
		//SimpleDateFormat df = 	new SimpleDateFormat("dd/MM/yyyy");
		
	
		
		
			for( GradProjectFile file : listfiles ) {
		
			if(file != null) {
		
			
		  if(((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) >= year1 
				 &&  ((int)em.createQuery("select EXTRACT(YEAR FROM f.anneeScolaire) from GradProjectFile f where f.id =:id").setParameter("id", file.getId()).getSingleResult()) <= year2) {
			  listfileBetwwen2Years.add(file);
		  }
			}
		}
		
		return listfileBetwwen2Years;
	}


	
	
	
	
	
	
	
	@Override
	public Map<projectCategory, Double> autoCompletePreferdCategorie(int idt) {
		
		
		
		Map<projectCategory, Double> categoriesScores = new HashMap<>();
		Teacher t = em.find(Teacher.class, idt);		
		
		Set<projectCategory> proposedCategories = t.getCategoriesProposed();
		Set<projectCategory> encaredCategories = new HashSet<>();
		Set<projectCategory> ropportedCategories = new HashSet<>();
		Set<projectCategory> skillsCategories = new HashSet<>();
		List<projectCategory> allCategories = categorieser.getCategories();
		
		for(Skill sk : t.getSkills()) {
			skillsCategories.add(sk.getCategorie());
		}
	
		for(GradProjectFile file :listerFileEncadrer(idt)) {
			encaredCategories.addAll(file.getCategoriesoffile());
		}

		for(GradProjectFile file :listerFileRapporter(idt)) {
			ropportedCategories.addAll(file.getCategoriesoffile());
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");

		}
		/*System.out.println("proposed :"+proposedCategories.size());
		System.out.println("proposed :"+preferedCategories.size());
		System.out.println("proposed :"+skillsCategories.size());*/
		
		System.out.println(encaredCategories.size());
		
		for(projectCategory c : allCategories) {
			categoriesScores.put(c, 1.0);
		}
		
		
		//adition dans la map
		for(projectCategory c :proposedCategories) {
			categoriesScores.put(c, categoriesScores.get(c)*5);
		}
		for(projectCategory c :skillsCategories) {
			categoriesScores.put(c, categoriesScores.get(c)*2);
		}
		for(projectCategory c :encaredCategories) {
			categoriesScores.put(c, categoriesScores.get(c)*1.5);
		}
		for(projectCategory c :ropportedCategories) {
			categoriesScores.put(c, categoriesScores.get(c)*1.2);
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");

			}
		
		
		Map<projectCategory,Double> result = categoriesScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		return result;
	}


	
	
	@Override
	public Map<projectCategory, Integer> getmostencadredCategorie(int idt) {
		Map<projectCategory, Integer> categoriesStat = new HashMap<>();
		Teacher t = em.find(Teacher.class, idt);	
		Set<projectCategory> encaredCategories = new HashSet<>();
		
		for(GradProjectFile file :listerFileEncadrer(idt)) {
			encaredCategories.addAll(file.getCategoriesoffile());
		}
		
		for(projectCategory c : encaredCategories) {
			categoriesStat.put(c, 0);
		}
		
		
		//tret
		for(GradProjectFile file :listerFileEncadrer(idt)) {
			for(projectCategory c :file.getCategoriesoffile()) {
				if(categoriesStat.get(c)!=null) {
				categoriesStat.put(c, categoriesStat.get(c)+1);
				}
			}
		}
		
		
		Map<projectCategory,Integer> result = categoriesStat.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		return result;
	}

	
	
	
	@Override
	public Map<projectCategory, Integer> getmostRapportedCategorie(int idt) {
		Map<projectCategory, Integer> categoriesStat = new HashMap<>();
		Teacher t = em.find(Teacher.class, idt);	
		Set<projectCategory> encaredCategories = new HashSet<>();
		
		
		// en cours
		for(GradProjectFile file :listerFileRapporter(idt)) {
			encaredCategories.addAll(file.getCategoriesoffile());
		}
		
		for(projectCategory c : encaredCategories) {
			categoriesStat.put(c, 0);
		}
		
		
		//tret
		for(GradProjectFile file :listerFileRapporter(idt)) {
			for(projectCategory c :file.getCategoriesoffile()) {
				if(categoriesStat.get(c)!=null) {
				categoriesStat.put(c, categoriesStat.get(c)+1);
				}
			}
		}
		
		
		Map<projectCategory,Integer> result = categoriesStat.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		return result;
	}


	@Override
	public Map<projectCategory, Integer> getmostpresedentCategorie(int idt) {
		Map<projectCategory, Integer> categoriesStat = new HashMap<>();
		Teacher t = em.find(Teacher.class, idt);	
		Set<projectCategory> encaredCategories = new HashSet<>();
		
		for(GradProjectFile file :listerFilePresedent(idt)) {
			encaredCategories.addAll(file.getCategoriesoffile());
		}
		
		for(projectCategory c : encaredCategories) {
			categoriesStat.put(c, 0);
		}
		
		
		//tret
		for(GradProjectFile file :listerFilePresedent(idt)) {
			for(projectCategory c :file.getCategoriesoffile()) {
				if(categoriesStat.get(c)!=null) {
				categoriesStat.put(c, categoriesStat.get(c)+1);
				}
			}
		}
		
		
		Map<projectCategory,Integer> result = categoriesStat.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		return result;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	@Override
	public Map<GradProjectFile, Double> getFileMostNote(int idt) {
		Map<GradProjectFile, Double> fileStat = new HashMap<>();
		Teacher t = em.find(Teacher.class, idt);	
		Set<projectCategory> encaredCategories = new HashSet<>();
		
		for(GradProjectFile file :listerFileEncadrer(idt)) {
			encaredCategories.addAll(file.getCategoriesoffile());
		}
		
		
		
		
		//tret
		Map<Integer, Double> prvsids = new HashMap<>();
		for(GradProjectFile file :listerFileEncadrer(idt)) {
			 
			if(fileStat.containsKey(file)) {
				fileStat.put(file, (fileStat.get(file)+file.getNote()) / 2);
			}else {
				fileStat.put(file, file.getNote());
			}
			
		}
		
		
		Map<GradProjectFile,Double> result = fileStat.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		
		
		
		return result;
	}


	@Override
	public Map<projectCategory, Double> getcategorieMostNote(int idt) {
		Set<GradProjectFile> files = listerFileEncadrer(idt);
		 Map<projectCategory, Double> mapcat = new HashMap<>();
		 
		 for(GradProjectFile file : files) {
			 for(projectCategory c : file.getCategoriesoffile()) {
				 if(mapcat.containsKey(c)) {
					mapcat.put(c, (mapcat.get(c)+ file.getNote())/2  );
					
				 }
				 else {
						mapcat.put(c,file.getNote() );
					}
				}
		 }
		
		
		 Map<projectCategory, Double> result = mapcat.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		return result;
	}

	
	
	@Override
	public Map<projectCategory, Double> getcategorieMostNoteenTTQRapporteur(int idt) {
		Set<GradProjectFile> files = listerFileRapporter(idt);
		 Map<projectCategory, Double> mapcat = new HashMap<>();
		 
		 for(GradProjectFile file : files) {
			 for(projectCategory c : file.getCategoriesoffile()) {
				 if(mapcat.containsKey(c)) {
					mapcat.put(c, (mapcat.get(c)+ file.getNote_rapporteur())/2  );
					
				 }
				 else {
						mapcat.put(c,file.getNote_rapporteur() );
					}
				}
		 }
		
		
		 Map<projectCategory, Double> result = mapcat.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		return result;
	}


	
	
	
	
	
	
	

	@Override
	public void donnerUnMotif(int idt, int idfile, String motif, String role) {

		Set<GradProjectFile> pfefiles ;
		if(role.equals("encadrant")) {
pfefiles = listerFileEncadrer(idt);
		}
		else {
			 pfefiles = listerFileRapporter(idt);
		}
		
		for( GradProjectFile file : pfefiles ) {
			if(file != null) {
			if(file.getId() == idfile) {
				file.setMotif(motif);;
				
				// Action
				Timestamp time = new Timestamp(System.currentTimeMillis());
					
					ActionTeacher action = new ActionTeacher(" Motif fiche pfe"," vous avez attribuer un motif a la fiche de"
							+file.getStudent().getFirstName()+"  "+file.getStudent().getFirstName()+ " en ttq "+role+" le "+time,null);
					ActionService.ajouterteacherAction(idt, action);
				
			}
			}
		}
		
		
	}


	@Override
	public User authetificate(String login, String password) {
	User  u = null;
		TypedQuery<User> query = em.createQuery("select e from User e where e.password  =:password and e.email =:email   ",User.class).setParameter("password", password)
				.setParameter("email", login);
		
		try {
			u= query.getSingleResult();
		} catch (Exception e2) {
			System.out.println(" pas de resulta");
		}
		
		return u;
	}


	
	

	


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
