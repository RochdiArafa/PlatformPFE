package rest.TemplatePFE;


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

import tn.pfe.entity.TemplatePFE;
import tn.pfe.service.TemplatePFE.TemplatePFEServiceRemote;


@Path("templatePFE")
public class TemplatePFERest {
	
	@EJB(mappedName="PlatformPFE-ear/PlatformPFE-ejb/TemplatePFEService!tn.pfe.service.TemplatePFE.TemplatePFEServiceRemote")  
	TemplatePFEServiceRemote templateService;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response ajouter(@QueryParam(value="template") String template) {
		TemplatePFE T = new TemplatePFE(template);
		
		templateService.ajouter(T);
		return Response.status(Status.CREATED).entity(T).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String modifier(@QueryParam(value="id") int id , @QueryParam(value="template") String Template) {
		
		TemplatePFE T = new TemplatePFE(id, Template);
		
		if(searchTemplatePFE(T.getId()) != null) {
			templateService.modifier(T);;
			return "The object was updated !";
		}
		else	
			return "there is no object with the id = "+id;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TemplatePFE searchTemplatePFE(@QueryParam(value="id")int id) {
		return templateService.search(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String delteTemplatePFE(@QueryParam(value="id")int id) {
		if(searchTemplatePFE(id) != null) {
			templateService.delete(id);
			return "The object was deleted !";
	}
	else	
		return "there is no object with the id = "+id;
	}
	
	@GET
	@Path("/export")
	@Produces(MediaType.APPLICATION_JSON)
	public String exportTemplatePFE(@QueryParam(value="id")int id) {
		templateService.exportTemplateFile(id);
		return "Template exported !!";
	}
	
	
	
	

}
