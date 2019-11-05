package PfeRes;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.TeacherService;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Teacher;

@Path("/teacherres")
public class TeacherRes {

	@EJB
	TeacherService teacherServices;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/affecterencadrant")
	public void affecterencadrant(@QueryParam("idStu") int idStu) {
		teacherServices.encadrerEtudiant(idStu);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/affecterrapporteur")
	public void affecterapporteur(@QueryParam("idStu") int idStu) {
		teacherServices.rappporterEtudiant(idStu);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pfesansrapporteur")
	public List<GradProjectFile> getpfesansrapporteur(){
		return teacherServices.AfficherListeSansRapporteurs();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updaterapporteur")
	public void updatepfe(@QueryParam("idst") int idst,@QueryParam("idt") int idt) {
		teacherServices.updateRapporteur(idst, idt);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateencadrant")
	public void updateencadrant(@QueryParam("idst") int idst,@QueryParam("idt") int idt) {
		teacherServices.updateEncadrant(idst, idt);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/teachers")
	public Map<Teacher, List<GradProjectFile>> getteachers(){
		return teacherServices.teacherbynbencadrement();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pfewithoutrap")
	public List<GradProjectFile> getpfesansrapporteurs(){
		return teacherServices.fichesansrapporteur();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pfewithoutencadrant")
	public List<GradProjectFile> getpfesansencadrants(){
		return teacherServices.fichesansencadrant();
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/validecat")
	public void validecat(@QueryParam("idcat") int idcat) {
		teacherServices.validercat(idcat);
	}

}
