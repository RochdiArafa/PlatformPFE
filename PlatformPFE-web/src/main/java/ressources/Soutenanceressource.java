package ressources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
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
	   public List <Soutenance> affpfevalide() throws ParseException{
			SimpleDateFormat sd= new SimpleDateFormat("hh/dd/MM/yyyy");
		   return ss.algo("/01/04/1996", es.pfe_v_E_R(), sc.affclasses());}
	   
	   
	   

	   @Path("algo")
	   @GET
	   @Produces(MediaType.TEXT_PLAIN)
	   @Consumes(MediaType.APPLICATION_JSON)
	   public String  addalgo() throws ParseException {
		   List<Soutenance> s=ss.algo("01/04/1996 ", es.getpfe(), sc.affclasses());
		   ss.add(s);
		   
		   
		   return "ok";
	   
	   
	   }
	   
}
