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

import rest.Secured;
import tn.esprit.Services.servicesiteLocal;
import tn.pfe.entity.Site;
import tn.pfe.entity.TemplatePFE;
import tn.pfe.service.TemplatePFE.TemplatePFEServiceLocal;


@Path("templatePFE")
public class TemplatePFERest {
	
	@EJB
	TemplatePFEServiceLocal templateService;
	
	@EJB
	servicesiteLocal serviceSite;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String ajouter(@QueryParam(value="template") String template , @QueryParam(value="site_id") int site_id) {
		Site s = serviceSite.getSiteById(site_id);
		if(s != null) {
			TemplatePFE T = new TemplatePFE(template , s);
			templateService.ajouter(T);
			return "Template added";
		}else
			return "there is no Site with the id = "+site_id;	
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String modifier(@QueryParam(value="id") int id , @QueryParam(value="template") String Template , @QueryParam(value="site_id") int site_id) {
		Site s = serviceSite.getSiteById(site_id);
		
		if(s != null) {
			TemplatePFE T = new TemplatePFE(id, Template , s);
			
			if(searchTemplatePFE(T.getId()) != null) {
				templateService.modifier(T);;
				return "The Template was updated !";
			}
			else	
				return "there is no Template with the id = "+id;
		}
		else
			return "there is no Site with the id = "+site_id;
			
	}
	
	@Secured
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
