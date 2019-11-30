package ressources;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import tn.esprit.Services.SkillServices;

import tn.pfe.entity.Skill;

@Path("skills")
public class SkillRessources {

	@EJB
	SkillServices skillser;
	
	
	@POST
	@Path("{idt}/{idc}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addskills(@PathParam("idt")int idt,@PathParam("idc")int idc,Skill sk) {
		
		skillser.addSkill(idt, idc, sk);
		
	}                                         
	
	@GET
	@Path("{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Skill> getteacherkills(@PathParam("idt")int idt) {
		
		return skillser.getTeacherSkills(idt);
		
	}       
	
	
	
	
}
