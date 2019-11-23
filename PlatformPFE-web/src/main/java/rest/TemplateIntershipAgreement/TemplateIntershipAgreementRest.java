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

import tn.esprit.Services.servicesiteLocal;
import tn.pfe.entity.Site;
import tn.pfe.entity.TemplateIntershipAgreement;
import tn.pfe.service.TemplateIntershipAgreement.TemplateIntershipAgreementServiceLocal;


@Path("templateIntershipAgreement")
public class TemplateIntershipAgreementRest {
	
	@EJB
	TemplateIntershipAgreementServiceLocal templateIntershipAgreementService;
	
	@EJB
	servicesiteLocal serviceSite;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String ajouter(@QueryParam(value="template") String template , @QueryParam(value="site_id") int site_id) {
		Site s = serviceSite.getSiteById(site_id);
		if(s != null) {
		TemplateIntershipAgreement T = new TemplateIntershipAgreement(template);
		T.setSite(s);
		templateIntershipAgreementService.ajouter(T);
		return "Template added";
		}
		else
			return "there is no Site with the id = "+site_id;
			
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String modifier(@QueryParam(value="id") int id , @QueryParam(value="template") String Template , @QueryParam(value="site_id") int site_id) {
		Site s = serviceSite.getSiteById(site_id);

		if(s != null) {
			TemplateIntershipAgreement T = new TemplateIntershipAgreement(id, Template , s );
			
			if(searchTemplateIntershipAgreement(T.getId()) != null) {
				templateIntershipAgreementService.modifier(T);;
				return "The object was updated !";
			}
			else	
				return "there is no Template with the id = "+id;
		}else
			return "there is no Site with the id = "+id;
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
	
	@GET
	@Path("/export")
	@Produces(MediaType.APPLICATION_JSON)
	public String exportTemplatePFE(@QueryParam(value="id")int id) {
		templateIntershipAgreementService.exportTemplateIntershipAgreement(id);
		return "Template exported !!";
	}
	
	
	

}
