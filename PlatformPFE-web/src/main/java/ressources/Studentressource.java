package ressources;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.servicestudent;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Student;



@Path("student")
public class Studentressource {
@EJB
servicestudent es ;

@POST
@Path("{ida}")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public String addetudiant( @PathParam("ida")int ida,Student s) {
	es.addstudent(s);
	es.affecter_A_toS(s.getId(), ida);
	
	return "etudiant ajouter avec succes ";
	
}

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Student> affetds() {
	   return es.affStudent();
	   
   }
   @Path("tt")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<GradProjectFile> affpfe() {
	   return es.getpfe();
	   
   }
   
   
   @DELETE
   @Path("{ids}")
   @Produces(MediaType.TEXT_PLAIN)
   public String suppetd(@PathParam("ids")int ids) {
	   
	   es.deleteStudentbyid(ids);
	   
	   return " etudient supprimer";
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.TEXT_PLAIN)
   public String update(Student s) {
	   es.updateSrudent(s);
	   return "etudiant modifier avec success";
   }
   
   @Path("pfe")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List <GradProjectFile> affpfevalide(){
	   return es.pfe_v_E_R();}
   
   @Path("mail")
   @GET
   @Produces(MediaType.TEXT_PLAIN)
   public String mail() {
es.notifchefdepartement();
	   return "mail ok"
;   }
   
 
}
