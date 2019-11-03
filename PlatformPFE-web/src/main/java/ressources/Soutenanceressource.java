package ressources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.serviceclasses;
import tn.esprit.Services.servicesoutenance;
import tn.esprit.Services.servicestudent;
import tn.pfe.entity.Classes;
import tn.pfe.entity.Soutenance;
import tn.pfe.entity.Teacher;



@Path("soutenance")
public class Soutenanceressource {
	@EJB
	servicesoutenance ss;
	@EJB
	servicestudent es;
	@EJB
	serviceclasses sc ;
	
	@POST
	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addetudiant( Soutenance s) throws ParseException {
		SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	//s.setDatesoutenance(sd.parse("02/02/2012 08:00:00"));
		s.setDatesoutenance(  sd.parse("01/01/2010 08:00:00"));
ss.addsoutenance(s);

		return "etudiant ajouter avec succes ";}
	
	 
	   @GET
	   @Produces(MediaType.APPLICATION_JSON)
	   public List <Integer> affpfevalide() throws ParseException{
		   SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		   Date d =sd.parse("03/11/2019 08:00:00");
		   return ss.teacherocupper(d);}
	   
	   @Path("{idt}")
	   @GET
	   @Produces(MediaType.TEXT_PLAIN)
	   public boolean verif(@PathParam("idt")int idt) throws ParseException {
		   
		   SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		   Date d =sd.parse("03/11/2019 08:00:00");
		   return ss.affecterpresident(d,idt);
		   
	   }
	   

	   @Path("algo")
	   @GET
	   @Produces(MediaType.TEXT_PLAIN)
	   @Consumes(MediaType.APPLICATION_JSON)
	   public String  addalgo() throws ParseException {
		   List<Soutenance> s=ss.algo("01/04/1996 ", es.getpfe(), sc.affclasses());
		   ss.add(s);
		   
		   
		   return "ok";
	   
	   
	   }
	   @POST
	   @Path("affecterpresident/{ids}/{idp}")
	   @Produces(MediaType.TEXT_PLAIN)
	   public String affecterdstos(@PathParam(value = "ids")int ids,@PathParam(value = "idp")int idp) throws ParseException {
		   SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		   Date d =sd.parse("03/11/2019 08:00:00");
	  String s="";
	   	if(es.affecterPtoS(ids, idp, d)==false) {
	   		s=s+"president affecter avec succes";
	   		
	   	}else
	   		s=s+"erreur d'affectation il faut chercher un ensiegnant libre dans cette date";
	   	
	   	return s;
	   
}
	   
}
