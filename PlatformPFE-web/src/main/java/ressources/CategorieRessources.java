package ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.datatype.joda.deser.PeriodDeserializer;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import tn.esprit.Services.CategorieService;
import tn.pfe.entity.projectCategory;

@Path("categories")
public class CategorieRessources {

	@EJB
	CategorieService catser;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<projectCategory> getallCategories() {
		return catser.getCategories();
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addCategorie(projectCategory c) {
		catser.addCategorie(c);
		return "categorie added";
	}
	
	@DELETE
	@Path("{idc}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCategorie(@PathParam("idc")int idc) {
		catser.deleteCategorieById(idc);
		return "categorie deleted";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCategorie(projectCategory c) {
		catser.updateCtegorie(c);
		return "categorie updated";
	}
	
	@POST
	@Path("{idc}/{idt}")
	@Produces(MediaType.TEXT_PLAIN)
	public String affecterproposedcategorie(@PathParam("idc")int idc, @PathParam("idt")int idt) {
		catser.affecterCategorieToTeacher(idc, idt);
		return "categorie affected";
	}
	
	@POST
	@Path("preferedCat/{idc}/{idt}")
	@Produces(MediaType.TEXT_PLAIN)
	public String affecterpreferedcategorie(@PathParam("idc")int idc, @PathParam("idt")int idt) {
		catser.affecterCategorieToTeacher(idc, idt);
		return "categorie affected";
	}
	
	
	
	@DELETE
	@Path("DELETEpreferedCat/{idc}/{idt}")
	@Produces(MediaType.TEXT_PLAIN)
	public String SUPPRIMERpreferedcategorie(@PathParam("idc")int idc, @PathParam("idt")int idt) {
		catser.deletepreferedCategori(idt, idc);;
		return "categorie affected";
	}
	
	
	
	
}
