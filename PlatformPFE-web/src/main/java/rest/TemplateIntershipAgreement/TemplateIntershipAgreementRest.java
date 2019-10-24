package rest.TemplateIntershipAgreement;


import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.pfe.entity.TemplateIntershipAgreement;
import tn.pfe.service.TemplateIntershipAgreement.TemplateIntershipAgreementServiceRemote;


@Path("templateIntershipAgreement")
public class TemplateIntershipAgreementRest {
	
	@EJB(mappedName="PlatformPFE-ear/PlatformPFE-ejb/TemplateIntershipAgreementService!tn.pfe.service.TemplateIntershipAgreement.TemplateIntershipAgreementServiceRemote")  
	TemplateIntershipAgreementServiceRemote templateIntershipAgreementService;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response ajouter(@QueryParam(value="template") String template) {
		TemplateIntershipAgreement T = new TemplateIntershipAgreement(template);
		
		templateIntershipAgreementService.ajouter(T);
		return Response.status(Status.CREATED).entity(T).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String modifier(@QueryParam(value="id") int id , @QueryParam(value="template") String Template) {
		
		TemplateIntershipAgreement T = new TemplateIntershipAgreement(id, Template);
		
		if(searchTemplateIntershipAgreement(T.getId()) != null) {
			templateIntershipAgreementService.modifier(T);;
			return "The object was updated !";
		}
		else	
			return "there is no object with the id = "+id;
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TemplateIntershipAgreement searchTemplateIntershipAgreement(@QueryParam(value="id")int id) {
		return templateIntershipAgreementService.search(id);
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteTemplateIntershipAgreement(@QueryParam(value="id")int id) {
		if(searchTemplateIntershipAgreement(id) != null) {
			templateIntershipAgreementService.delete(id);
			return "The object was deleted !";
		}
		else	
			return "there is no object with the id = "+id;
	}
	
	
	

}
