package rest.Company;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.projectCategory;
import tn.pfe.service.Company.CompanyServiceRemote;
import tn.pfe.service.categorie.ProjectCategorieRemote;


@Path("company")
public class CompanyRest {

	@EJB(mappedName="PlatformPFE-ear/PlatformPFE-ejb/CompanyService!tn.pfe.service.Company.CompanyServiceRemote")  
	CompanyServiceRemote companyService ;
	
	
	@GET
	@Path("/TopRecruted")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> getRecrutedCompayByOrder() {
		return  companyService.getRecrutedCompayByOrder();
	}
}
