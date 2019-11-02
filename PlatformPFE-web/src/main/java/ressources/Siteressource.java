package ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.servicesites;
import tn.pfe.entity.Site;



@Path("site")
public class Siteressource {
@EJB
servicesites ss;


@POST
@Path("{ida}")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public String addsite(Site site ,@PathParam("ida")int ida) {
	ss.addsite(site);
	ss.affecter_A_toS(site.getId(), ida);
return "c bn";	
}

@GET
@Produces(MediaType.APPLICATION_XML)
public List<Site> affesite(){
	
	return ss.affsite();
}
@DELETE
@Path("{id}")
@Produces(MediaType.TEXT_PLAIN)
public String deletesite(@PathParam(value = "id")int id) {
	ss.deletesitebyid(id);
	return "Site supprimer";
}

@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateecole(Site s) {
	ss.updatesite(s);;
	
	return "site modifer" ;
}

@POST
@Path("affecterdireteurtosite/{ids}/{idds}")
@Produces(MediaType.TEXT_PLAIN)
public String affecterdstos(@PathParam(value = "ids")int ids,@PathParam(value = "idds")int idds) {
	ss.affecter_DS_toS(ids, idds);
	
	return " affectation done !!";
}

}
